package robbers;

import java.util.ArrayList;
import java.util.LinkedList;

public class House {


    private double assets;
    private LinkedList<Integer> values;
    private boolean isRobbed;
    private boolean isRobbable;

    public House(double assets, boolean isRobbed, boolean isRobbable){

        this.assets = assets;
        this.isRobbed = isRobbed;
        this.isRobbable = isRobbable;

    }

    public void setAssets(double assets){
        this.assets = assets;
    }

    public double getAssets(){
        return assets;

    }

    public void setIsRobbed(boolean isRobbed){
        this.isRobbed = isRobbed;
    }
    public boolean getIsRobbed(){
        return isRobbed;
    }
    public void setIsRobbable(boolean isRobbable){

    }

    @Override
    public String toString() {
        return "House{" +
                "assets=" + assets +
                '}';
    }
}
