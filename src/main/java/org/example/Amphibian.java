package org.example;

public class Amphibian extends Animal{
    public Amphibian(int AnimalID, String name, String animalSound, String animalDescription) {
        super(AnimalID, name, animalSound, animalDescription);
    }

    @Override
    public void feed() {
        System.out.println(this.animalSound);
    }

    @Override
    public void read() {
        System.out.println(this.animalDescription);
    }

    @Override
    public String toString() {
        return ("\nAnimalID: " + AnimalID + "\nAnimal Name: " + name + "\nAnimal Type: Amphibian");
    }
}
