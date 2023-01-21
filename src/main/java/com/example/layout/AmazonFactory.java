package com.example.layout;

public class AmazonFactory implements AnimalFactory {

    @Override
    public Animal[] createAnimals() {

        Animal animal[] = { new Tiger(), new Lion(), new Gorilla()
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
        // TODO Auto-generated method stub
        return 40;
    }
    
}
