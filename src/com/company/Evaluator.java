package com.company;

import java.util.ArrayList;

public class Evaluator {

  public static Application.STATUS evaluate(Application app) {
    ArrayList<String> evalErrors = new ArrayList<>();

    boolean instantReject = false;

    //Check for reject criterias
    if (!evaluateFirstName(app)) {
      evalErrors.add("First name not in proper format");
      instantReject = true;
    }

    if (!evaluateLastName(app)) {
      evalErrors.add("Last name not in proper format");
      instantReject = true;
    }

    if (!evaluateNumFelonies(app)) {
      evalErrors.add("1 or more felonies");
      instantReject = true;
    }

    double evaluatedGPA = evaluateGPA(app);
    if (evaluatedGPA < .7) {
      evalErrors.add("GPA is below 70% of scale provided on application.");
      instantReject = true;
    }

    if (instantReject) {
      app.setStatus(Application.STATUS.INSTANT_REJECT);
      app.setInstantRejectReasons(evalErrors);
    } else {
      boolean instantAccept = true;

      loop: for (int i = 0; i < 4; i++) {
        switch(i) {
          case 0:
            if (!evaluateAgeAndLocation(app)) {
              instantAccept = false;
              break loop;
            }
            break;
          case 1:
            if (evaluatedGPA < .9) {
              instantAccept = false;
              break loop;
            }
            break;
          case 2:
            if (!evaluateStandardizedTestScore(app)) {
              instantAccept = false;
              break loop;
            }
            break;
          default:
            break;
        }
      }

      if (instantAccept) {
        app.setStatus(Application.STATUS.INSTANT_ACCCEPT);
      } else {
        app.setStatus(Application.STATUS.NEEDS_FURTHER_REVIEW);
      }
    }
    return app.getStatus();
  }

  private static boolean evaluateFirstName(Application app) {
    return evaluateName(app.getFirstName());
  }

  private static boolean evaluateLastName(Application app) {
    return evaluateName(app.getLastName());
  }

  private static boolean evaluateName(String name) {
    if (name == null) return false;
    for (int i = 0; i < name.length(); i++) {
      if (i == 0) {
        if (!Character.isUpperCase(name.charAt(i))) {
          return false;
        }
      } else {
        if (Character.isUpperCase((name.charAt(i)))) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean evaluateNumFelonies(Application app) {
    return !app.isHasFeloniesWithin5Years();
  }

  private static double evaluateGPA(Application app) {
     double scale = app.getGpaScale() == Application.GPA_SCALE.FOURPOINT0 ? 4.0 : 5.0;
     return app.getGpa() / scale;
  }

  private static boolean evaluateAgeAndLocation(Application app) {
    if (app.getAge() > 80) {
      return true;
    }
    if (app.getAge() >= 17 && app.getAge() < 26 && app.getState() == Application.STATE.CA) {
      return true;
    }
    return false;
  }

  private static boolean evaluateStandardizedTestScore(Application app) {
    if (app.getSatScore() > 1920 || app.getActScore() > 27) {
      return true;
    }
    return false;
  }
}
