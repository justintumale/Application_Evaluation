package com.company;

public class Main {

    private static ApplicationAPI getAPIServer() {
      return ApplicationAPI.getInstance();
    }

    public static void main(String[] args) {
      ApplicationAPI api = getAPIServer();
    }
}
