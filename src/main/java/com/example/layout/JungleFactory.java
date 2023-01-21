package com.example.layout;

public class JungleFactory implements AnimalFactory {


    @Override
    public Animal[] createAnimals() {
        Animal animal[] = { new Tiger(), new Lion(), new Deer(), new Gorilla(),new Parrot()
                           ,new Rafflesia()};
        return animal;
    }

    @Override
    public Animal[] createAnomalies() {
        Animal animal[] = { new Whale()};
        
        return animal;
    }

    @Override
    public Integer totalScore() {
        return 60;
    }

    
}
