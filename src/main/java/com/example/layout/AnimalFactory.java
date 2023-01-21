package com.example.layout;

public interface AnimalFactory {
    public abstract Entity createTiger();
    public abstract Entity createLion();
    public abstract Entity createDeer();
    public abstract Entity createDoll();
    public abstract Entity createGorilla();
    public abstract Entity createLight();
    public abstract Entity createMonitor();
    public abstract Entity createParrot();
    public abstract Entity createRafflesia();
    public abstract Entity createTrash();
    public abstract Entity createWhale();

    public static int total = 11;
    //tiger,lion,monkey,bird,giraffe,panda
}
