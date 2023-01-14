// muhammad hazieq bin hannan
// 17205298
// group 4
package com.example.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {

  @Override
  public void log(String msg) {
    try {
      File filelog = new File("logger.txt");

      FileWriter fileWriter = new FileWriter("logger.txt", true);

      BufferedWriter writer = new BufferedWriter(fileWriter);

      Date date = new Date();

      String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
      
      String log = String.format("%s: %s", timeStamp.toString(), msg);

      if (!filelog.createNewFile() && filelog.length() != 0) {
        writer.newLine();
      }
      writer.write(log);
      writer.close();
    } catch (Exception e) {
    }
  }

}
