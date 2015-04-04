package car;

public class Ferrari extends Car implements Properties{
    public void setTopSpeed(int speed){
        this.topSpeed=speed;
    }
    public void setBrand(){
        this.brand="Ferrari";
    }
    public void setModel(String model){
        this.model=model;
    }
    @Override
    public void accelerate(int increment){
        this.speed+=increment;
        System.out.println("The Ferrari"+" "+this.getModel()+" speeds up very quickly!");
    }

}
