package com.example.layout;

public class JungleFactory implements AnimalFactory {

    @Override
    public Entity[] createAnimals() {
        Entity animal[] = { new Tiger(), new Deer(), new Gorilla(), new Parrot(), new Rafflesia() };
        return animal;
    }

    @Override
    public Entity[] createAnomalies() {
        Entity animal[] = { new Whale(), new Monitor(), new Doll(), new Lights(), new Trash() };

        return animal;
    }

    @Override
    public Integer totalScore() {
        return 60;
    }

}
