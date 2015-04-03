package toDoList;

import java.util.Comparator;

public class TaskComparator implements Comparator< Task> {

    @Override
    public int compare(Task t1, Task t2) {
        
        return t1.priority<=t2.priority ? -1:1;
    }

}
