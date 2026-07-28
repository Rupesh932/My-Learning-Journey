package core.CoreBasic.interfaceinjava.afterjava8;

public class InterfaceAfterJava8 {
    public static void main(String[] args) {
        System.out.println("========== REGULAR CAR INFO: ============= ");
        Vehicle regularCar = new RegularCar();
        regularCar.accelerateInfo();
        regularCar.autoDrive();
        regularCar.drive();
        Vehicle.brake();

        System.out.println("========== MODERN CAR INFO: ============= ");
        Vehicle modernCar = new ModernCar();
        modernCar.accelerateInfo();
        modernCar.drive();
        modernCar.autoDrive();
        Vehicle.brake();

        System.out.println("========== BIKE INFO: ============= ");
        Vehicle bike = new Bike();
        bike.accelerateInfo();
        bike.autoDrive();
        bike.drive();
        Vehicle.brake();
    }

}
interface Vehicle{

    void drive();

    //after java 8 --> default method introduce
    default void autoDrive(){
        System.out.println("AUTO DRIVE COMING SOON");

    }
    static void brake(){
        System.out.println("APPLYING BREAK");
    }
    //after java 9
    private void accelerate(){
        // this is private method, non can access it outside the class, but inside this interface it can be useful
        System.out.println("ACCELERATE UPTO 300 KM/H");

    }
    default void accelerateInfo(){
        accelerate();
    }


}

class RegularCar implements Vehicle{
    @Override
    public void drive(){
        System.out.println("DRIVE REGULAR CAR");
    }
    @Override
    public void autoDrive(){
        System.out.println("REGULAR CAR: AUTO DRIVE CAN INSTALLED AT LOW COST");
    }
}

class ModernCar implements Vehicle{

    @Override
    public void drive() {
        System.out.println("DRIVE MODERN CAR.");
    }

    @Override
    public void autoDrive() {
        System.out.println("MODERN CAR :ENABLED AUTO DRIVE, GET THE FUCK OFF");
    }
    @Override
    public void accelerateInfo(){
        System.out.println("MODERN CAR : CAN ACCELERATE UPTO 650 KM/H");
    }
}
class Bike implements Vehicle{

    @Override
    public void drive() {
        System.out.println("DRIVE BIKE");
    }

    @Override
    public void accelerateInfo() {
        System.out.println("BIKE CAN ACCELERATE UPTO 200 KM/H");
    }
}