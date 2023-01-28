package com.example.layout;

public class SeaFactory implements AnimalFactory {

    @Override
    public Entity[] createAnimals() {

        Entity animal[] = { new Coral(), new Turtle(), new Nemo(), new Octopus(), new SeaHorse() };
        return animal;
    }

    @Override
    public Entity[] createAnomalies() {
        Entity animal[] = { new Watch(), new FishingRod(), new PlasticBag(), new WaterBottle(), new RubberDuck() };

        return animal;
    }

    @Override
    public Integer totalScore() {
        return 40;
    }

}
