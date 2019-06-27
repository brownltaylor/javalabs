package animalfactory.animaltypes;

import animalfactory.abstractions.Animal;
import animalfactory.attributes.*;

public class Dog extends Animal {

    @Override
    public void createAnimal(){
        attributes.add(new Ears());
        attributes.add(new Eyes());
        attributes.add(new Fur());
        attributes.add(new Legs());
        attributes.add(new Nose());
        attributes.add(new Tail());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "attributes=" + attributes +
                '}';
    }
}
