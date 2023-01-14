package com.example.Log;

import java.util.Properties;

public class LoggerFactory {
    public Logger createLogger() {
        Logger logger = null;
        Properties p = new Properties();
        try {
            
            p.load(ClassLoader.getSystemResourceAsStream("Logger.properties"));
            String fileLoggingValue = p.getProperty("FileLogging");
            System.out.println("test");
            if (fileLoggingValue.equalsIgnoreCase("ON") == true) {
                logger = new FileLogger();
            } else {
                logger = new ConsoleLogger();
            }
            return logger;
        } catch (Exception e) {
            return logger;
        }
    }  
}
