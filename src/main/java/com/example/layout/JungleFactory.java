package com.example.layout;

public class JungleFactory implements AnimalFactory {

    @Override
    public Entity createTiger() {
        return new Tiger();
    }

    @Override
    public Entity createLion() {
        return new Lion();
    }
    
}
