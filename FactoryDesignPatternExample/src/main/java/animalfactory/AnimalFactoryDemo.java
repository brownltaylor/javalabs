package animalfactory;


import animalfactory.abstractions.Animal;
import animalfactory.factory.AnimalFactory;

public class AnimalFactoryDemo {

    public static void main(String[] args) {

        Animal bird = AnimalFactory.getAnimal(AnimalFactory.AnimalType.BIRD);

        System.out.println(bird);
    }
}