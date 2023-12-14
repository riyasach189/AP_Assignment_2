package org.example;

public abstract class Animal {
    protected final int AnimalID;
    protected String name;
    protected String animalSound;
    protected String animalDescription;

    public Animal(int AnimalID, String name, String animalSound, String animalDescription) {
        this.AnimalID = AnimalID;
        this.name = name;
        this.animalSound = animalSound;
        this.animalDescription = animalDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnimalID() {
        return AnimalID;
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    @Override
    public String toString() {
        return ("\nAnimalID: " + AnimalID + "\nAnimal Name: " + name);
    }

    public abstract void feed();
    public abstract void read();

}
