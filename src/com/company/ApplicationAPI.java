package com.company;

public class ApplicationAPI {

  private static ApplicationAPI _instance = null;
  private static DataAPI _dataAPI = null;

  //constructor
  private ApplicationAPI() {
    _dataAPI = DataAPI.getInstance();
    GlobalProperties.initialize();
  }

  public static ApplicationAPI getInstance(){
    if (_instance == null) {
      _instance = new ApplicationAPI();
    }
    return _instance;
  }

  public Application getNewApplication() {
    return new Application();
  }

  public Application getApplication(String id) {
    return _dataAPI.getApplication(id);
  }

  public Application.STATUS submitApplication(Application app) {
    app.setStatus(Evaluator.evaluate(app));
    _dataAPI.saveApplication(app.getEmail(), app);
    return app.getStatus();
  }

}
