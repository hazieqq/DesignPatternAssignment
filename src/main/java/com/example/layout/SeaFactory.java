package com.example.layout;

public class SeaFactory implements AnimalFactory {

    @Override
    public Entity[] createAnimals() {

        Entity animal[] = { new Coral() };
        return animal;
    }

    @Override
    public Entity[] createAnomalies() {
        Entity animal[] = { new Watch() };

        return animal;
    }

    @Override
    public Integer totalScore() {
        return 40;
    }

}
