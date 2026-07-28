package core.CoreBasic.oopinjava.abstraction;

public class JavaLLAbstraction {
    public static void main(String[] args) {
        //Low level abstraction(hiding implementation details)
        FuelCar maruti = new FuelCar();
        maruti.start();
        maruti.accelerate();
        maruti.applyBreak();
        maruti.stop();

        ElectricCar eMaruti = new ElectricCar();
        eMaruti.start();
        eMaruti.accelerate();
        eMaruti.applyBreak();
        eMaruti.stop();
    }
}

class FuelCar{
    String color;
    String model;
    int fuelTankCapacity;
    public void start(){
        System.out.println("Car is starting");
    }
    public void accelerate(){
        System.out.println("car is accelerated, are you good?");
    }
    public void applyBreak(){
        System.out.println("break applied, car is slowing down");
    }
    public void stop(){
        System.out.println("Car is Stopped, good driving");
    }
    public void autoDrive(){
        System.out.println("Enabled auto driving, enjoy your time");
    }
}
 class ElectricCar{
    String color;
    String model;
    String batteryPower;
    int batteryCount;
    String batteryCurrentLife;
    boolean isBatteryCharged;

     public void start(){
         System.out.println(this+" is starting");
     }
     public void accelerate(){
         System.out.println("car is accelerated, are you good?");
     }
     public void applyBreak(){
         System.out.println("break applied, car is slowing down");
     }
     public void stop(){
         System.out.println("Car is Stopped, good driving");
     }
     public void autoDrive(){
         System.out.println("Enabled auto driving, enjoy your time");
     }
 }