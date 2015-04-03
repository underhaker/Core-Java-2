package toDoList;

import java.util.Random;

public class Task {
    protected int priority;
    protected float time;
    protected boolean isFinished;
    protected String name;
    public float getTime(){
        return this.time;
    }
    public Task(int priority,int time){
        this.priority=priority;
        this.time=time;
    }
    public Task(){
        this.priority=new Random().nextInt(10);
        this.time=new Random().nextInt(10)+1;
    }
    
    public Task(int time){
        this.priority=new Random().nextInt(10);
        this.time=time;
    }
    public String toString(){
        return this.name;
    }
    /*
    public Task(int time){
        Task(new Random().nextInt(10)+1,time);
    }*/
    /*
    public void StudyForAlgebraTask(int priority){
        Random rand = new Random();
        this.time=rand.nextInt(10) + 1;
        this.priority=priority;
        
        this.isFinished=false;
    }
    public void LearnGeometryTask(){
        Random rand = new Random();
        this.time=rand.nextInt(10)+1;
        this.priority=rand.nextInt(10)+1;
        this.isFinished=false;
        //default priority, smaller than 10
    }
    public void GoOutTask(int time){
        this.priority=new Random().nextInt(10)+1;
        this.time=time;
        this.isFinished=false;
        //default priority, smaller than 10
    }
    public void SleepTask(){
        this.priority=new Random().nextInt(10)+1;
        this.time=8;
        this.isFinished=false;
        //straight 8 hours, of course!
    }*/
    public void setFinished(){
        isFinished=true;
    }
}
