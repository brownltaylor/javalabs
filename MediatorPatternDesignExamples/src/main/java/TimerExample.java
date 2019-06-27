import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample{

    private Timer timer;

    //represents the Mediator
    public TimerExample(int seconds){
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        timer.schedule(new RemindTaskWithoutBeep(), seconds * 2 * 1000);
    }

    //Colleague
    class RemindTask extends TimerTask{
        public void run(){
            System.out.println("Time's up!");

        }
    }

    //Colleague
    class RemindTaskWithoutBeep extends TimerTask{
        public void run(){
            System.out.println("Now Time's really up!");
            timer.cancel();
        }
    }

    //Colleague
    public static void main(String[] args) {

        System.out.println("About to schedule task.");
        new TimerExample(5);
        System.out.println("Task scheduled.");

    }
}
