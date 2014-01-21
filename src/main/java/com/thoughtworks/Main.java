package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.base.Strings;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

  private static final String EXIT = "exit";

  public static void main(String args[]) {
    Injector injector = Guice.createInjector();
    InputTypeParser typeParser = injector.getInstance(InputTypeParser.class);
    BufferedReader reader = null;
    try {
      reader = getConsoleReader();
    } catch (IOException e) {
      System.out.println("Not able to get ConsoleReader .. Exiting");
      return;
    }
    String line = null;
    line = readLine(reader, line);
    while(!line.equals(EXIT)) {
      String resp = typeParser.parseAndHandleStatement(line);
      if (!Strings.isNullOrEmpty(resp)) {
        System.out.println(resp);
      }
      line = readLine(reader, line);
    }
  }

  private static String readLine(BufferedReader reader, String line) {
    try {
      line = reader.readLine();
    } catch (IOException e) {
      System.out.println("Not able to read line .. Exiting");
      return EXIT;
    }
    return line;
  }

  private static BufferedReader getConsoleReader() throws IOException {
    return new BufferedReader(new InputStreamReader(System.in));
  }
}
