package pancakeExample;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    protected List<Pancake> pancakes = new ArrayList<Pancake>();

    public void startPancake(Pancake pancake){
        pancakes.add(pancake);
    }


    public void flip() {
        for (Pancake pancake : pancakes) {
            if (pancake.isReadyToBeFlipped()) {
                pancake.setFlipped(true);
            }
        }
    }
}
