package car;

public class Audi extends Car implements CrashProperties {
    public void setTopSpeed(int speed){
        this.topSpeed=speed;
    }
    public void setBrand(){
        this.brand="Audi";
    }
    public void setModel(String model){
        this.model=model;
    }
    public void Crash(){
        System.out.println("You are very capable of avoiding a crash!");
    }
    @Override 
    public int getMileAge(){
        System.out.println("You have a very high mileage!");
        return this.mileAge;
    }
}
