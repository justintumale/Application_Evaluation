package com.company;

import static org.junit.Assert.*;

public class ApplicationAPITest {

  private ApplicationAPI _api;

  @org.junit.Before public void setUp() throws Exception {
    _api = ApplicationAPI.getInstance();
  }

  @org.junit.After public void tearDown() throws Exception {
  }

  @org.junit.Test public void submitApplicationInstantAccept() {
    //instant accept
    Application application = _api.getNewApplication();
    application.setFirstName("Johnna");
    application.setLastName("Java");
    application.setAge(18);
    application.setState(Application.STATE.CA);
    application.setGpa(3.6);
    application.setGpaScale(Application.GPA_SCALE.FOURPOINT0);
    application.setSatScore(1930);
    application.setActScore(28);
    application.setHasFeloniesWithin5Years(false);
    application.setEmail("johnnajava@gmail.com");
    Application.STATUS result = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result);
    assertEquals(Application.STATUS.INSTANT_ACCCEPT, result);
  }

  @org.junit.Test public void submitApplicationInstantRejectGPA() {
    Application application = _api.getNewApplication();
    application.setFirstName("Andy");
    application.setLastName("Cee");
    application.setAge(20);
    application.setState(Application.STATE.CA);
    application.setGpa(2.7);
    application.setGpaScale(Application.GPA_SCALE.FOURPOINT0);
    application.setSatScore(1930);
    application.setActScore(29);
    application.setHasFeloniesWithin5Years(false);
    application.setEmail("acee@gmail.com");
    Application.STATUS result2 = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result2);
    assertEquals(Application.STATUS.INSTANT_REJECT, result2);
  }

  @org.junit.Test public void submitApplicationInstantRejectFirstName() {
    Application application = _api.getNewApplication();
    application.setFirstName("aNdy");
    application.setLastName("Cee");
    application.setAge(20);
    application.setState(Application.STATE.CA);
    application.setGpa(3.9);
    application.setGpaScale(Application.GPA_SCALE.FOURPOINT0);
    application.setSatScore(1930);
    application.setActScore(29);
    application.setHasFeloniesWithin5Years(false);
    application.setEmail("acee2@gmail.com");
    Application.STATUS result2 = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result2);
    assertEquals(Application.STATUS.INSTANT_REJECT, result2);
  }

  @org.junit.Test public void submitApplicationInstantRejectLastName() {
    Application application = _api.getNewApplication();
    application.setFirstName("Andy");
    application.setLastName(null);
    application.setAge(20);
    application.setState(Application.STATE.CA);
    application.setGpa(3.9);
    application.setGpaScale(Application.GPA_SCALE.FOURPOINT0);
    application.setSatScore(1930);
    application.setActScore(29);
    application.setHasFeloniesWithin5Years(false);
    application.setEmail("acee3@gmail.com");
    Application.STATUS result2 = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result2);
    assertEquals(Application.STATUS.INSTANT_REJECT, result2);
  }

  @org.junit.Test public void submitApplicationInstantRejectFelonies() {
    Application application = _api.getNewApplication();
    application.setFirstName("Andy");
    application.setLastName("Cee");
    application.setAge(20);
    application.setState(Application.STATE.CA);
    application.setGpa(3.9);
    application.setGpaScale(Application.GPA_SCALE.FOURPOINT0);
    application.setSatScore(1930);
    application.setActScore(29);
    application.setHasFeloniesWithin5Years(true);
    application.setEmail("acee4@gmail.com");
    Application.STATUS result2 = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result2);
    assertEquals(Application.STATUS.INSTANT_REJECT, result2);
  }

  @org.junit.Test public void submitApplicationInstantNeedsFurtherReview() {
    Application application = _api.getNewApplication();
    application.setFirstName("Chris");
    application.setLastName("Farley");
    application.setAge(21);
    application.setState(Application.STATE.GA);
    application.setGpa(4.5);
    application.setGpaScale(Application.GPA_SCALE.FIVEPOINT0);
    application.setSatScore(1930);
    application.setActScore(29);
    application.setHasFeloniesWithin5Years(false);
    application.setEmail("cfarley@gmail.com");
    Application.STATUS result = _api.submitApplication(application);
    ApplicationUtil.printResult(application, result);
    assertEquals(Application.STATUS.NEEDS_FURTHER_REVIEW, result);
  }


}