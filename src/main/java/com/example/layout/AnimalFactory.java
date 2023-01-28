package com.example.layout;

public interface AnimalFactory {
    public Entity[] createAnimals();
    public Entity[] createAnomalies();
    public Integer totalScore();
}
