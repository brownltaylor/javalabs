package robbers;

import javafx.collections.transformation.SortedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class Neighborhood {

    private ArrayList<House> houses;
    Neighborhood neighborhood;
    LinkedList<Double> values;

    public Neighborhood(ArrayList<House> houses) {

        this.houses = houses;

    }

    public ArrayList getHouses() {
        return houses;
    }

    public void populate(ArrayList<House> houses) {
        House house1 = new House(5000.20, false, true);
        House house2 = new House(6739.00, false, true);
        House house3 = new House(43000.00, false, true);
        House house4 = new House(18000.00, false, true);
        House house5 = new House(14593.00, false, true);
        House house6 = new House(43902.00, false, true);
        House house7 = new House(6943.00, false, true);
        House house8 = new House(12039.00, false, true);
        House house9 = new House(500.00, false, true);
        House house10 = new House(12304.00, false, true);
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);
        houses.add(house6);
        houses.add(house7);
        houses.add(house8);
        houses.add(house9);
        houses.add(house10);
    }

    public void rob(LootBag lootBag){

        neighborhood.extractAssets(values);




        }




    public void extractAssets(LinkedList<Double> values){

        for ( House house : houses) {
            values.add(house.getAssets());
        }

        Collections.sort(values);
        System.out.println(values);
    }


}


