package com.example.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements Logger {

  @Override
  public void log(String msg) {
    Date date = new Date();
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
    String log = String.format("%s: %s", timeStamp.toString(), msg);
    System.out.println(log);
  }

}
