package com.example.layout;

import java.util.ArrayList;
import java.util.List;

public class Functions implements Publisher {
    private static Functions uniqueInstance;
    public AnimalLayout animalImage;
    private List<Subscriber> subscriber;
    private ArrayList<String> animalVisible;

    private Functions(AnimalLayout animalImage) {
        subscriber = new ArrayList<>();
        animalVisible = new ArrayList<>();
        this.animalImage = animalImage;
    }

    private Functions() {
        subscriber = new ArrayList<>();
        animalVisible = new ArrayList<>();
    }


    public static Functions getInstance() {
        if (uniqueInstance == null) {
            // uniqueInstance = new Functions(new AnimalLayout());
            uniqueInstance = new Functions();
        }
        return uniqueInstance;
    }

    public void switchVisibility(String animal) {
        // System.out.print(animal);
        if (animalVisible.contains(animal)) {
            animalVisible.remove(animal);
        } else {
            animalVisible.add(animal);
        }
        // animalImage.toggleVisibility(animal);
        // System.out.println(text);
        // System.out.println(animal);
        // textAndAnimal.put(animal, text);
        notifySubscriber();
    }


    @Override
    public void registerSubscriber(Subscriber subs) {
        subscriber.add(subs);
    }


    @Override
    public void removeSubscriber(Subscriber subs) {
        // just remove , nothing mucch !
        subscriber.remove(subs);
    }


    @Override
    public void notifySubscriber() {
        for (Subscriber subs : subscriber){
            subs.updateVisible(animalVisible);
        }
        
    }
    

}
