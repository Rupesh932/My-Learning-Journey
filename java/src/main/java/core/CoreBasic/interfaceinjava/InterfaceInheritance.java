package core.CoreBasic.interfaceinjava;

public class InterfaceInheritance {
    public static void main(String[] args) {

    }
}
interface Animal{
    void eat();

}

// interface can't implement interface that's why interface extends interface.
interface Dog extends Animal{
    void bark();
}

interface TrainedDog extends Dog{
    void discipline();
}

interface Bird extends Animal{
    void fly();
}

interface HunterBird extends Bird{
    void hunt();
}

class GermanShepherd implements TrainedDog{
    @Override
    public void discipline() {

    }

    @Override
    public void bark() {

    }

    @Override
    public void eat() {

    }
}

class Vulture implements HunterBird{

    @Override
    public void hunt() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void eat() {

    }
}
