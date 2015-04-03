package toDoList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class ToDoList extends Task {
    
    private int currentTime;
    private int maxTime;
    private PriorityQueue<Task> queue;
    ToDoList(int maxTime){
        this.maxTime=maxTime;
        this.currentTime=0;
        queue=new PriorityQueue<Task>(new TaskComparator());
    }
    public void addTask(Task t){
        queue.offer(t);
    }
    public void markFinished(Task t){
        currentTime-=t.getTime();
        queue.remove(t);
    }
    public void markCancelled(Task t){
        queue.remove(t);
    }
    public Task top(){
        return queue.peek();
    }
    public int getTimeNeeded(){
        PriorityQueue<Task> q=queue;
        int stime=0;
        while(q.size()!=0){
            stime+=q.peek().getTime();
            q.remove();
        }
        return stime;
    }
    public boolean canFinish(){
        PriorityQueue<Task> q=queue;
        int ctime=0;
        while(q.size()!=0){
            ctime+=q.peek().getTime();
            q.remove();
        }
        if(ctime<=maxTime)return true;
        else return false;
    }
    public int getRemainingTime(){
        PriorityQueue<Task> q=queue;
        int ctime=0;
        while(q.size()!=0){
            ctime+=q.peek().getTime();
            q.remove();
        }
        return maxTime-ctime;
    }
    public static void main(String[] args) {
        ToDoList todo = new ToDoList(11); //11 hours remaining!
        todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
        todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
        todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
        todo.addTask(new SleepTask()); //straight 8 hours, of course!

        /*if (todo.canFinish()){
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }*/

        //System.out.println(todo.top().toString()); //StudyForAlgebraTask
        //System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list
        System.out.println(todo.getRemainingTime());
    }
    
}
