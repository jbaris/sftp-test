package com.wordpress.jbaris;

public class CustomLogger implements com.jcraft.jsch.Logger {

  static java.util.Hashtable name=new java.util.Hashtable();

  static{
    name.put(DEBUG, "DEBUG: ");
    name.put(INFO, "INFO: ");
    name.put(WARN, "WARN: ");
    name.put(ERROR, "ERROR: ");
    name.put(FATAL, "FATAL: ");
  }

  public boolean isEnabled(int level){
    return true;
  }

  public void log(int level, String message){
    System.err.print(name.get(level));
    System.err.println(message);
  }

}
