package com.example.layout;


public class Functions {
    private static Functions uniqueInstance;

    private Functions() {
    }

    public static Functions getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Functions();
        }
        return uniqueInstance;
    }

    

}
