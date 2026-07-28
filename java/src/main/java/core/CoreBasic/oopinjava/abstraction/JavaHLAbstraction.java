package core.CoreBasic.oopinjava.abstraction;

public class JavaHLAbstraction {
    public static void main(String[] args) {
        //High level abstraction(separate WHAT and HOW)
        Car eMaruti = new ElectricCarModel();
        eMaruti.start();
        eMaruti.autoDrive();
        eMaruti.accelerate();
        eMaruti.applyBreak();
        eMaruti.stop();

        Car fMaruti = new FuelCarModel();
        fMaruti.start();
        fMaruti.autoDrive();
        fMaruti.accelerate();
        fMaruti.applyBreak();
        fMaruti.stop();

    }
}

abstract class Car {
    String color;
    String model;

    abstract void autoDrive();

    abstract void accelerate();

    public void start() {
        System.out.println(this.getClass() + "  is starting");
    }

    public void applyBreak() {
        System.out.println(this.getClass()+ " applied breaks, car is slowing down");
    }

    public void stop() {
        System.out.println(this.getClass()+ " is Stopped, good driving");
    }

}

class ElectricCarModel extends Car {

    String batteryPower;
    int batteryCount;
    String batteryCurrentLife;
    boolean isBatteryCharged;

    @Override
    public void accelerate() {
        System.out.println("Electric car  is accelerated, are you good?");
    }

    @Override
    public void autoDrive() {
        System.out.println("ElectricCar Enabled auto driving, enjoy your time");
    }

    @Override
    public void applyBreak() {
        super.applyBreak();
        System.out.println("Electric car break applied, its slowing down as expected and battery is charging");
    }
}

class FuelCarModel extends Car {

    int fuelTankCapacity;

    @Override
    public void start() {
        super.start();
        System.out.println("Fuel Model car is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Fuel car  is accelerated, are you good?");
    }

    @Override
    public void autoDrive() {
        System.out.println("Fuel car Enabled auto driving, enjoy your time");
    }

}
