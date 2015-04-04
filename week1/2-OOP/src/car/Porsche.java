package car;

public class Porsche extends Car implements Properties{
    public void setTopSpeed(int speed){
        this.topSpeed=speed;
    }
    public void setBrand(){
        this.brand="Porsche";
    }
    public void setModel(String model){
        this.model=model;
    }
    @Override
    public int getMileAge(){
        
        return this.mileAge;
    }

}
