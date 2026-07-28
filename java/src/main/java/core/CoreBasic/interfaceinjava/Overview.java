package core.CoreBasic.interfaceinjava;

public class Overview {
    public static void main(String[] args) {
        Car thar = new Thar();
        thar.drive();

        Car ford = new Ford();
        ford.drive();

        Car tesla = new TeslaImpl();
        tesla.drive();

    }
}
interface Car{
    void drive();
}
 class Thar implements Car{
    @Override
    public void drive() {
        System.out.println("DRIVING THAR");
    }
}
class Ford implements Car{
    @Override
    public void drive() {
        System.out.println("DRIVING FORD");
    }

}
abstract class Tesla implements  Car{
    abstract public void drive();
}
class TeslaImpl extends Tesla{
    @Override
    public void drive(){
        System.out.println("DRIVING TESLA");
    }
}
