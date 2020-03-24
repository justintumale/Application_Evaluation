package com.company;

import java.util.HashMap;

public class Cache {
  private static Cache _instance;
  private static HashMap<String, Application> _cache;
  private static int _maxCacheSize = 10;

  private Cache() {
    _cache = new HashMap<String, Application>();
    if (GlobalProperties.properties.getProperty("cache.size") != null) {
      _maxCacheSize = Integer.parseInt(GlobalProperties.properties.getProperty("cache.size"));
    }
  }

  public static Cache getInstance() {
    if (_instance == null) {
      _instance = new Cache();
    }
    return _instance;
  }

  public void saveApplication(String id, Application app) {
    synchronized(_cache) {
      if (_cache.size() == _maxCacheSize ) {
        /*Ideally, for computational's sake, we would have a more optimal cache eviction
        policy once the cache gets full (such as LRU).  The current logic clears
        the cache after reaching maximum capacity.  The advantage is easier development
        and simpler logic and the disadvantage is that the cache will have to be
        completely repopulated after it's cleared.
        */
        _cache.clear();
      }
      _cache.put(id, app);
    }
  }

  public Application getApplication(String id) {
    return _cache.get(id);
  }
}
