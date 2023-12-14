package org.example;

public class Mammal extends Animal{
    public Mammal(int AnimalID, String name, String animalSound, String animalDescription) {
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
        return ("\nAnimalID: " + AnimalID + "\nAnimal Name: " + name + "\nAnimal Type: Mammal");
    }
}
