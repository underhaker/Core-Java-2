package toDoList;

import java.util.Random;

public class StudyForAlgebraTask extends Task {
    public StudyForAlgebraTask(int priority) {
        this.name="StudyForAlgebraTask";
        this.priority=priority;
        this.time=new Random().nextInt(10)+1;
        // TODO Auto-generated constructor stub
    }
    
}
