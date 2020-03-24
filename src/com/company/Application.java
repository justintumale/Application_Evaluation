package com.company;

import java.util.ArrayList;

public class Application {

  public enum STATUS {
    INSTANT_ACCCEPT,
    INSTANT_REJECT,
    NEEDS_FURTHER_REVIEW
  }

  public enum STATE {
    AK, AL, AR, AZ, CA, CO, CT, DC, DE, FL, GA, HI, IA, ID,
    IL, IN, KS, KY, LA, MA, MD, ME, MI, MN, MO, MS, MT, NC,
    ND, NE, NH, NJ, NM, NV, NY, OH, OK, OR, PA, RI, SC, SD,
    TN, TX, UT, VA, VT, WA, WI, WV, WY
  }

  public enum GPA_SCALE {
    FOURPOINT0, FIVEPOINT0
  }

  private String _email;
  private String _firstName;
  private String _lastName;
  private int _age;
  private STATE _state;
  private double _gpa;
  private GPA_SCALE _gpaScale;
  private int _satScore;
  private int _actScore;
  private boolean _hasFeloniesWithin5Years;
  private STATUS _status;
  private ArrayList<String> _instantRejectReasons = null;

  public Application() {
    _email = null;
    _firstName = null;
    _lastName = null;
    _age = -1;
    _state = null;
    _gpa = 0.0;
    _gpaScale = null;
    _satScore = -1;
    _actScore = -1;
    _hasFeloniesWithin5Years = false;
    _status = null;
    _instantRejectReasons = new ArrayList<String>();
  }

  public String getAppId() {
    return _email;
  }

  public String getEmail() {
    return _email;
  }

  public void setEmail(String email) {
    _email = email;
  }

  public String getFirstName() {
    return _firstName;
  }

  public void setFirstName(String firstName) {
    _firstName = firstName;
  }

  public String getLastName() {
    return _lastName;
  }

  public void setLastName(String lastName) {
    _lastName = lastName;
  }

  public int getAge() {
    return _age;
  }

  public void setAge(int age) {
    _age = age;
  }

  public STATE getState() {
    return _state;
  }

  public void setState(STATE state) {
    _state = state;
  }

  public double getGpa() {
    return _gpa;
  }

  public void setGpa(double gpa) {
    _gpa = gpa;
  }

  public GPA_SCALE getGpaScale() {
    return _gpaScale;
  }

  public void setGpaScale(GPA_SCALE gpaScale) {
    _gpaScale = gpaScale;
  }

  public int getSatScore() {
    return _satScore;
  }

  public void setSatScore(int satScore) {
    _satScore = satScore;
  }

  public int getActScore() {
    return _actScore;
  }

  public void setActScore(int actScore) {
    _actScore = actScore;
  }

  public boolean isHasFeloniesWithin5Years() {
    return _hasFeloniesWithin5Years;
  }

  public void setHasFeloniesWithin5Years(boolean hasFeloniesWithin5Years) {
    _hasFeloniesWithin5Years = hasFeloniesWithin5Years;
  }

  public STATUS getStatus() {
    return _status;
  }

  public void setStatus(STATUS status) {
    _status = status;
  }

  public ArrayList<String> getInstantRejectReasons() { return _instantRejectReasons; }

  public void setInstantRejectReasons(ArrayList<String> instantRejectReasons) {
    _instantRejectReasons = instantRejectReasons;
  }
}
