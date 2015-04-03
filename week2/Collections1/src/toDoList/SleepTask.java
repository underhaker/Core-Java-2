package toDoList;

import java.util.Random;

public class SleepTask extends Task {
    public SleepTask() {
        this.name="SleepTask";
        this.priority=new Random().nextInt(10);
        this.time=new Random().nextInt(10)+1;
    }
    

}
