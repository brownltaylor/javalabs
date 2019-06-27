package lightswitchExample;

import java.util.ArrayList;
import java.util.List;


public class Mediator {

    private List<Light> lights = new ArrayList<Light>();

    public void registerLight(Light light){
        lights.add(light);
    }


    public void turnOnAllLights(){
        for(Light light : lights) {
            if (!light.isOn()) {
                light.toggle();
                System.out.println("Turning " + light.getLocation() + " on.");
            }
            System.out.println(light.getLocation() + " is on!");
        }
    }

    public void turnOffAllLights() {
        for (Light light : lights) {
            if (light.isOn()) {
                light.toggle();
                System.out.println("Turning " + light.getLocation() + "  off.");
            }
            System.out.println(light.getLocation() + " is off");
        }
    }

    }

