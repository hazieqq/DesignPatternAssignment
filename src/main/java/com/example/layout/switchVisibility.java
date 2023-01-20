package com.example.layout;

public class switchVisibility implements Command {
    private String animal;

    public switchVisibility(String animal) {
        this.animal = animal;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        Functions.getInstance().switchVisibility(animal);
    }
}
