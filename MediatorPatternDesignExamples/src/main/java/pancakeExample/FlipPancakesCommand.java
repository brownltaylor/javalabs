package pancakeExample;

public class FlipPancakesCommand implements Command {

    private Mediator mediator;

    public FlipPancakesCommand(Mediator mediator){
        this.mediator = mediator;
    }

    public void execute(){
        mediator.flip();
    }
}
