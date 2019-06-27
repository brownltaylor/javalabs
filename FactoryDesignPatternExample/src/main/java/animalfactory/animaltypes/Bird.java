package animalfactory.animaltypes;

import animalfactory.abstractions.Animal;
import animalfactory.attributes.Beak;
import animalfactory.attributes.Eyes;
import animalfactory.attributes.Feathers;
import animalfactory.attributes.Wings;

public class Bird extends Animal {

    @Override
    public void createAnimal(){
        attributes.add(new Wings());
        attributes.add(new Feathers());
        attributes.add(new Eyes());
        attributes.add(new Beak());

    }

    @Override
    public String toString() {
        return "Bird{" +
                "attributes=" + attributes +
                '}';
    }
}
