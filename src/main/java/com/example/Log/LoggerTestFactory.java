package com.example.Log;

public class LoggerTestFactory {
    static LoggerFactory factory;

    public LoggerTestFactory(LoggerFactory factory) {
        LoggerTestFactory.factory = factory;
    }

    public static Logger getLogger() {
        Logger logger;

        logger = factory.createLogger();

        return logger;
      
    }
}