package animalfactory.factory;

import animalfactory.abstractions.Animal;
import animalfactory.animaltypes.Bird;
import animalfactory.animaltypes.Dog;
import animalfactory.animaltypes.Fish;

public class AnimalFactory {

    public enum AnimalType{
        BIRD, DOG, FISH;
    }
    public static Animal getAnimal(AnimalType animalType){
        switch(animalType) {
            case BIRD: {
                return new Bird();
            }
            case DOG: {
                return new Dog();
            }
            case FISH: {
                return new Fish();
            }
            default: {
                return null;
            }
        }
    }


}
