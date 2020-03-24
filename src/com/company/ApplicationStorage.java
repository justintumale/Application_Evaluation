package com.company;

import java.util.HashMap;

/*
  This class is used to represent accessing an actual storage/database which involves
  writing to disk.  In order to increase performance I created a write through Cache
  which sits in front of this Application Storage class.  Reads are first done to the
  Cache to access an object.  If that object does not exist in the Cache then we'll
  check this class if it exists.
 */
public class ApplicationStorage {

  private static ApplicationStorage _instance;
  private static HashMap<String, Application> _storage;

  private ApplicationStorage() {
    _storage = new HashMap<String, Application>();
  }

  public static ApplicationStorage getInstance() {
     if (_instance == null) {
       _instance = new ApplicationStorage();
     }
     return _instance;
  }

  public void saveApplication(String id, Application app) {
    synchronized(_storage) {
      _storage.put(id, app);
    }
  }

  public Application getApplication(String id) {
    return _storage.get(id);
  }
}
