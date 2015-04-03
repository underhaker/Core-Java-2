package toDoList;

import java.util.Random;

public class LearnGeometryTask extends Task {
    public LearnGeometryTask() {
        this.name="LearnGeometryTask";
        this.priority=new Random().nextInt(10);
        this.time=(float)new Random().nextInt(10);
    }
}
