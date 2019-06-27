package animalfactory.animaltypes;

import animalfactory.abstractions.Animal;
import animalfactory.attributes.Eyes;
import animalfactory.attributes.Tail;

public class Fish extends Animal {

    @Override
    public void createAnimal(){
        attributes.add(new Eyes());
        attributes.add(new Tail());

    }

    @Override
    public String toString() {
        return "Fish{" +
                "attributes=" + attributes +
                '}';
    }
}
