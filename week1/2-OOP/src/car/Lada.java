package car;

public class Lada extends Car implements CrashProperties{
    public void setTopSpeed(int speed){
        this.topSpeed=speed;
    }
    public void setBrand(){
        this.brand="Lada";
    }
    public void setModel(String model){
        this.model=model;
    }
    @Override
    public void Crash(){
        System.out.println("Due to the high amount of vodka available,you are very likely to crash!");
    }

}
