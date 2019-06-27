package animalfactory.abstractions;


import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    protected List<Attribute> attributes = new ArrayList<>();

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Animal(){
        this.createAnimal();
    }

    public abstract void createAnimal();
}
