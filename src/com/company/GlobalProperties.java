package com.company;

import java.io.*;
import java.util.*;

/*
  Used for loading the application's configuration file into a static data structure
  which can be accessed by different parts of the application when needed.
 */
public class GlobalProperties {

  public static Properties properties = null;

  static {
    initialize();
  }

  public static void initialize()  {
    properties = new Properties();
    FileInputStream fis = null;
    try {
      String fileName = "resources/config/config.properties";
      ClassLoader classLoader = new GlobalProperties().getClass().getClassLoader();
      File file = new File(classLoader.getResource(fileName).getFile());
      fis = new FileInputStream(file);
      properties.load(fis);
    } catch(FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } finally {
      try {
        fis.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }
}
