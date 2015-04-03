package toDoList;

import java.util.Random;

public class GoOutTask extends Task {
    public GoOutTask(float time) {
        this.name="GoOutTask";
        this.priority=new Random().nextInt(10);
        this.time=time;
    }
}
