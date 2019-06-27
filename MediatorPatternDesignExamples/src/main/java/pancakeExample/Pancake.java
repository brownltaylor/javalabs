package pancakeExample;

import java.util.Timer;
import java.util.TimerTask;

public class Pancake {

    private Pancake pancake;
    private boolean isFlipped = false;
    private boolean isDone = false;
    private boolean isReadyToBeFlipped = false;
    private Timer flipTimer;
    private Timer doneTimer;

    public Pancake(){

    }

    public Pancake(boolean isDone){
        flipTimer = new Timer();
        flipTimer.schedule(new FlipTimer(), 10 * 1000);
        doneTimer = new Timer();
        doneTimer.schedule(new DoneTimer(), 15 * 1000 );
    }


//    public void flip() {
//        if (isReadyToBeFlipped) {
//            pancake.flip();
//        }
//    }


    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isReadyToBeFlipped() {
        return isReadyToBeFlipped;
    }

    public void setReadyToBeFlipped(boolean ready){
        this.isReadyToBeFlipped = ready;
    }


    class FlipTimer extends TimerTask {

        public void run() {
            pancake.setReadyToBeFlipped(true);
            System.out.println("Pancake ready to be flipped!");
        }
    }

    class DoneTimer extends TimerTask{
        public void run(){
            pancake.setDone(true);
            System.out.println("Pancakes are done!");
        }
    }

}
