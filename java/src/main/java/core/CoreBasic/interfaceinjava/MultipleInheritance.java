package core.CoreBasic.interfaceinjava;


public class MultipleInheritance {
    public static void main(String[] args) {
        Eagle goldenEagle = new GoldenEagle();
        System.out.println("Golden Eagle info: ");
        System.out.println("Aerodynamicity : "+Flyable.AERODYNAMIC);
        goldenEagle.hunt();
        goldenEagle.fly();
        goldenEagle.highSpeed();
        goldenEagle.maxFlyingHeight();

        System.out.println("======================================");
        System.out.println("Puffin info: ");
        System.out.println("Aerodynamicity : "+Flyable.AERODYNAMIC);
        System.out.println("Hydrodynamicity: "+ Swimmable.HYDRODYNAMIC);
        DivingBirds puffin = new Puffin();
        puffin.swim();
        puffin.underWaterSpeed();
        puffin.fly();
        puffin.highSpeed();
        puffin.maxFlyingHeight();

        System.out.println("======================================");
        System.out.println("Duck info: ");
        System.out.println("Aerodynamicity : "+Flyable.AERODYNAMIC);
        System.out.println("Hydrodynamicity: "+ Swimmable.HYDRODYNAMIC);
        Duck duck = new Duck();
        duck.fly();
        duck.swim();



    }
}
// java doesn't allow multiple inheritance through class because of diamond problem
// but multiple inheritance possible through interface.
interface Flyable{
    boolean AERODYNAMIC = true;
    void fly();


}
interface Swimmable{
    boolean HYDRODYNAMIC = true;
    void swim();
}

abstract class FlyingBirds implements Flyable{

   abstract void highSpeed();
   abstract void maxFlyingHeight();
    @Override
    public void fly() {
        System.out.println("Flying birds spend their 70% life only to fly");
    }
}

abstract class Eagle extends FlyingBirds{
    void hunt(){
        System.out.println("All eagle are depends on hunting");
    }
}

class GoldenEagle extends Eagle{

    @Override
    void highSpeed() {
        System.out.println("Golden Eagle high speed is 270 km/h");
    }

    @Override
    void maxFlyingHeight() {
        System.out.println("Golden Eagle can reach upto 80 km height");
    }


}

abstract class DivingBirds extends FlyingBirds implements Swimmable{

    @Override
    public void swim() {
        System.out.println("Diving birds can swim deep under water");
    }
    abstract void underWaterSpeed();
}

class Puffin extends DivingBirds{

    @Override
    void underWaterSpeed() {
        System.out.println("Puffin has good speed under water");
    }

    @Override
    void highSpeed() {
        System.out.println("Puffin has good speed as well in surface");
    }

    @Override
    void maxFlyingHeight() {
        System.out.println("Puffin can reach up to 50km height");
    }
}

//direct
 class Duck implements Flyable,Swimmable{

    @Override
    public void fly() {
        System.out.println("Duck can fly");
    }

    @Override
    public void swim() {
        System.out.println("Duck can swim");
    }
}