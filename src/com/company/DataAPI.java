package com.company;

public class DataAPI {
  private static DataAPI _instance;
  private static Cache _cacheInstance;
  private static ApplicationStorage _storageInstance;

  private DataAPI() {
    _cacheInstance = Cache.getInstance();
    _storageInstance = ApplicationStorage.getInstance();
  }

  public static DataAPI getInstance() {
    if (_instance == null) {
      _instance = new DataAPI();
    }
    return _instance;
  }

  public void saveApplication(String id, Application app) {
    _cacheInstance.saveApplication(id, app);
    _storageInstance.saveApplication(id, app);
  }

  public Application getApplication(String id) {
    Application result = _cacheInstance.getApplication(id);
    if (result == null) {
      result = _storageInstance.getApplication(id);
    }
    return result;
  }
}
