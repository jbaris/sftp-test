package com.wordpress.jbaris;

/**
 * Based on https://programacion.net/articulo/conectar_via_sftp_con_java_1147
 */
public class Main {

  private static final int PORT = 22;

  public static void main(String[] args) {

    if(args.length != 5) {
      System.out.println("Usage HOST USERNAME PASSWORD FTP_PATH SOURCE_FILE.");
      System.out.println("Eg: java -jar target/sftptest-1.0-jar-with-dependencies.jar your.server.com juan Secret! /home/juan/ /tmp/test.txt");
      throw new IllegalArgumentException();
    }
    String HOST = args[0];
    String USERNAME = args[1];
    String PASSWORD = args[2];
    String FTP_PATH = args[3];
    String SOURCE_FILE = args[4];
    String[] split = SOURCE_FILE.split("/");
    String SOURCE_FILE_NAME = split[split.length - 1];

    try {
      SFTPConnector sshConnector = new SFTPConnector();
      sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
      sshConnector.addFile(FTP_PATH, SOURCE_FILE, SOURCE_FILE_NAME);
      sshConnector.disconnect();
      System.out.println("Success!");
    } catch (Exception ex) {
      ex.printStackTrace();
      ex.printStackTrace();
    }

  }

}
