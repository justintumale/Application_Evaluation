package com.company;

import java.util.ArrayList;

public class ApplicationUtil {
  public static void printResult(Application app, Application.STATUS result) {
    String submitter = app.getFirstName() + " " + app.getLastName() + " (" + app.getEmail() + ") ";
    switch(result) {
      case INSTANT_ACCCEPT:
        System.out.println(submitter + ": ACCEPTED");
        break;
      case INSTANT_REJECT:
        System.out.println(submitter + ": REJECTED");
        ArrayList<String> instantRejectReasons = app.getInstantRejectReasons();
        for (String reason : instantRejectReasons) {
          System.out.println("    - " + reason);
        }
        break;
      case NEEDS_FURTHER_REVIEW:
        System.out.println(submitter + ": NEEDS FURTHER REVIEW");
        break;
    }
  }
}