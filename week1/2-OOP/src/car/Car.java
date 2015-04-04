package car;

public abstract class Car implements Properties {
   protected int speed;
   protected int mileAge;
   protected int topSpeed;
   protected float price; 
   protected String brand;
   protected String model;
   public void accelerate(int increment){
       this.speed+=increment;
   }
   public void applyBrakes(int decrement){
       this.speed-=decrement;
   }
   @Override
   public int getMileAge(){
       return this.mileAge;
   }
   @Override
   public int getTopSpeed(){
       return this.topSpeed;
   }
   @Override
   public float getPrice(){
       return this.price;
   }
   @Override
   public String getBrand(){
       return this.brand;
   }
   @Override
   public String getModel(){
       return this.model;
   }
   @Override
   public int getSpeed(){
       return this.speed;
   }

}