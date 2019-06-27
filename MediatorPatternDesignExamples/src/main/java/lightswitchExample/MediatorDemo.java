package lightswitchExample;

public class MediatorDemo {

    public static void main(String[] args) {


        Mediator mediator = new Mediator();
        Light bedroomLight = new Light("bedroom");
        Light kitchenLight = new Light("kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);

        turnOnAllLightsCommand.execute();

        Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);

        turnOffAllLightsCommand.execute();
    }
}
