package lightswitchExample;

public class Light {

    private boolean isOn = false;

    private String location = "";

    public Light(){

    }

    public Light(String location){
        this.location = location;
    }

    public boolean isOn(){
        return isOn;
    }



    public String getLocation(){
        return location;
    }



    public void toggle() {
        if (isOn) {
            off();
        }
        if (!isOn) {
            on();
        }
    }

    public void off(){
        isOn = false;
        }

     public void on(){
        isOn = true;
     }


}
