package com.example.layout;


public class Functions extends AnimalButtonLayout {
    private static Functions uniqueInstance;
    public AnimalLayout animalImage;
    public AnimalButtonLayout animalButton;
    private static boolean check = false;

    private Functions(AnimalLayout animalImage) {
        this.animalImage = animalImage;
    }

    private Functions(AnimalButtonLayout animalButton) {
        this.animalButton = animalButton;
    }

    public static Functions getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Functions(new AnimalLayout());
        }
        return uniqueInstance;
    }

    public void switchVisibility(String animal) {
        // System.out.print(animal);
        String text = animalImage.toggleVisibility(animal);
        this.toggleButtonText(text, animal);
    }
    

}
