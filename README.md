# Intro
Test scp connection based on [JSch](http://www.jcraft.com/jsch/)

Based on https://programacion.net/articulo/conectar_via_sftp_con_java_1147

Created to debug an issue on Jenkins scp plugin https://plugins.jenkins.io/publish-over-ssh/

# Usage
    $ git clone https://github.com/jbaris/sftp-test.git
    $ cd sftp-test
    $ mvn clean package
    $ java -jar target/sftptest-1.0-jar-with-dependencies.jar HOST USERNAME PASSWORD FTP_PATH SOURCE_FILE

