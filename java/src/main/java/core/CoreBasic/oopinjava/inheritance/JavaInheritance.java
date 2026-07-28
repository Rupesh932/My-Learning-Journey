package core.CoreBasic.oopinjava.inheritance;

import java.time.LocalDateTime;

public class JavaInheritance {

    public static void main(String[] args) {
        Vehicle maruti = new Vehicle("white","maruti");
        maruti.start();
        System.out.println(maruti.toString());

        Car bmw = new Car("red","BMW",6,8,false,6);
        bmw.start();
        bmw.setGear();
        System.out.println(bmw.toString());

        Vehicle safari = new Car("red black","Safari",6,10,true,8);
        safari.start();
        //safari.setGear(); //compile error.
        System.out.println(safari.toString());

        Vehicle bike = new Vehicle("black","Honda");
        bike.start();
        System.out.println(bike.toString());

    }

}
class Vehicle{
    private  String color;
    private final String MODEL;
    private final LocalDateTime MANUFACTURED_DATE;

  Vehicle(String color,String model){
      this.color = color;
      this.MODEL = model;
      this.MANUFACTURED_DATE = LocalDateTime.now();
  }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return MODEL;
    }

    public LocalDateTime getMANUFACTURED_DATE() {
        return MANUFACTURED_DATE;
    }

    public void start(){
        System.out.println("\n"+MODEL+" manually started only");
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", model='" + MODEL + '\'' +
                ", manufacturedDate=" + MANUFACTURED_DATE +
                '}';
    }
}
class Car extends Vehicle{
    private int seatQuantity;
    private int cameraQuantity;
    private boolean autoBreak;
    private int noOfTyre;
    Car(String color,String model,int seatQuantity,int cameraQuantity,boolean autoBreak,int noOfTyre){
        super(color,model);
        this.seatQuantity = seatQuantity;
        this.cameraQuantity = cameraQuantity;
        this.autoBreak = autoBreak;
        this.noOfTyre = noOfTyre;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(int seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    public int getCameraQuantity() {
        return cameraQuantity;
    }

    public void setCameraQuantity(int cameraQuantity) {
        this.cameraQuantity = cameraQuantity;
    }

    public boolean isAutoBreak() {
        return autoBreak;
    }

    public void setAutoBreak(boolean autoBreak) {
        this.autoBreak = autoBreak;
    }

    public int getNoOfTyre() {
        return noOfTyre;
    }

    public void setNoOfTyre(int noOfTyre) {
        this.noOfTyre = noOfTyre;
    }

    @Override
    public void start(){
        System.out.println("\n"+getModel()+" remote also can starts your car.");
    }
    public void setGear(){
        System.out.println(super.getModel()+" 's  gear is sets");
    }

    @Override
    public String toString() {
        return "Car{" +
                "Model = "+getModel() +
                "\nColor = "+getColor() +
                "\nseatQuantity=" + seatQuantity +
                ",\nCameraQuantity=" + cameraQuantity +
                ", \nAutoBreak=" + autoBreak +
                ", \nNoOfTyre=" + noOfTyre +
                ",\nManufactured Date = "+getMANUFACTURED_DATE()+
                '}';
    }
}
