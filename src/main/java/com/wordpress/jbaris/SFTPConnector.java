package com.wordpress.jbaris;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.IOException;

public class SFTPConnector {

  private Session session;

  public void connect(String username, String password, String host, int port)
      throws JSchException, IllegalAccessException {
    if (this.session == null || !this.session.isConnected()) {
      JSch.setLogger(new CustomLogger());
      JSch jsch = new JSch();

      this.session = jsch.getSession(username, host, port);
      this.session.setPassword(password);

      this.session.setConfig("StrictHostKeyChecking", "no");
      session.setConfig("compression.s2c", "zlib@openssh.com,zlib,none");
      session.setConfig("compression.c2s", "zlib@openssh.com,zlib,none");
      this.session.connect();
    } else {
      throw new IllegalAccessException("SFTP session already created");
    }
  }

  public final void addFile(String ftpPath, String filePath,
      String fileName) throws IllegalAccessException, IOException,
      SftpException, JSchException {
    if (this.session != null && this.session.isConnected()) {
      ChannelSftp channelSftp = (ChannelSftp) this.session.
          openChannel("sftp");
      channelSftp.connect();
      channelSftp.cd(ftpPath);
      System.out.println(String.format("Creating %s at dir %s", fileName, ftpPath));
      channelSftp.put(filePath, fileName);
      System.out.println("File copied successfully");
      channelSftp.exit();
      channelSftp.disconnect();
    } else {
      throw new IllegalAccessException("No sftp session created");
    }
  }

  public final void disconnect() {
    this.session.disconnect();
  }

}
