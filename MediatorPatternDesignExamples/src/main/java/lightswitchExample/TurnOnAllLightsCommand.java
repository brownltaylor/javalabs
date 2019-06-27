package lightswitchExample;

//concrete command -- no reference to Light class, just the mediator
public class TurnOnAllLightsCommand implements Command {

    private Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator){
        this.mediator = mediator;
    }


    public void execute(){
        mediator.turnOnAllLights();
    }
}
