package robbers;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<House> houses = new ArrayList<House>();
        Neighborhood neighborhood = new Neighborhood(houses);
        neighborhood.populate(houses);
        System.out.println(neighborhood.getHouses());

        LinkedList<Double> values = new LinkedList<Double>();
        neighborhood.extractAssets(values);
    }
}
