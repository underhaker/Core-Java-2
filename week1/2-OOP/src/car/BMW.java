package car;

public class BMW extends Car implements Properties{
    public void HasNitro(){
        System.out.println("The BMW has a nitro boost!");
    }
    public void setTopSpeed(int speed){
        this.topSpeed=speed;
    }
    public void setBrand(){
        this.brand="BMW";
    }
    public void setModel(String model){
        this.model=model;
    }
    @Override
    public void accelerate(int increment){
        this.speed+=increment;
        System.out.println("The BMW speeds up!");
    }
    @Override
    public void applyBrakes(int decrement){
        this.speed-=decrement;
        System.out.println("The BMW slows down!");
    }

}
