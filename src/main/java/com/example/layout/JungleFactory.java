package com.example.layout;

public class JungleFactory implements AnimalFactory {

    @Override
    public Animal createTiger() {
        return new Tiger();
    }

    @Override
    public Animal createLion() {
        return new Lion();
    }
    
}
