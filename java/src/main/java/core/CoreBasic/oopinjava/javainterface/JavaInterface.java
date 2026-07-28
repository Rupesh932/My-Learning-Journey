package core.CoreBasic.oopinjava.javainterface;

public class JavaInterface {
    public static void main(String[] args) {
        // FuelCar — CarInterface मात्र
        AbstractCar fuelCar = new FuelCar();
        fuelCar.start();
        fuelCar.accelerate();
        fuelCar.applyBreak();
        fuelCar.stop();

        System.out.println("---");

        // ElectricCar — AutoDrivable, Camera, Battery सबै
        ElectricCar electricCar = new ElectricCar();
        electricCar.start();
        electricCar.accelerate();
        electricCar.applyBreak();


        if (electricCar.isCapable()) {
            electricCar.autoDrive(new MapService("Kathmandu", "Pokhara"));
        }

        electricCar.stop();

    }
}
interface CarInterface{

    void accelerate();

}

interface AutoDrivable {
    void autoDrive(MapService service);

}

interface Camera{
    void front();
    void back();
    void lFront();
    void lBack();
    void rFront();
    void rBack();
}

interface Battery{
    void batteryInstallation();
    boolean isCapable();
    double batteryPower();
}

class MapService{
    private String source;
    private String destination;
    public MapService(String source,String destination){
        this.source = source;
        this.destination = destination;
    }
    String getRoute(){
        return source+" -> "+destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

abstract class AbstractCar implements CarInterface{
    protected String carModel;
    protected String color;


    public void start() {
        System.out.println(carModel + " starting...");
    }

    public void applyBreak() {
        System.out.println(carModel + " slowing down...");
    }

    public void stop() {
        System.out.println(carModel + " stopped.");
    }

    public void playMusic() {
        System.out.println(carModel + " music playing...");
    }


    abstract protected void openAirBag();


}
class FuelCar extends AbstractCar{


    int fuelTankCapacity;

    public FuelCar() {
        this.carModel = "Fuel Car";
        this.color = "White";
        this.fuelTankCapacity = 50;
    }

    @Override
    public void start() {
        System.out.println(carModel + " engine revving up...");
    }

    @Override
    public void accelerate() {
        System.out.println(carModel + " accelerating, fuel consuming...");
    }

    @Override
    protected void openAirBag() {
        System.out.println(carModel + " airbag deployed!");
    }

}

class ElectricCar extends AbstractCar implements AutoDrivable,Battery,Camera{

    private String batteryPowerLevel;
    private int batteryCount;
    private boolean isBatteryCharged;

    public ElectricCar() {
        this.carModel = "Electric Car";
        this.color = "Black";
        this.isBatteryCharged = true;
        this.batteryCount = 4;
        this.batteryPowerLevel = "100%";
    }

    // ── AutoDrivable ──
    @Override
    public void autoDrive(MapService map) {
        if (isCapable()) {
            System.out.println(carModel + " auto driving on route: " + map.getRoute());
            front();
            lFront();
            rFront();
        } else {
            System.out.println(carModel + " cannot auto drive — battery low.");
        }
    }

    // ── Camera ──
    @Override
    public void front() {
        System.out.println("Front camera active");
    }

    @Override
    public void back() {
        System.out.println("Back camera active");
    }

    @Override
    public void lFront() {
        System.out.println("Left front camera active");
    }

    @Override
    public void lBack() {
        System.out.println("Left back camera active");
    }

    @Override
    public void rFront() {
        System.out.println("Right front camera active");
    }

    @Override
    public void rBack() {
        System.out.println("Right back camera active");
    }

    // ── Battery ──
    @Override
    public void batteryInstallation() {
        System.out.println(carModel + " battery installed. Count: " + batteryCount);
    }

    @Override
    public boolean isCapable() {
        return isBatteryCharged;
    }

    @Override
    public double batteryPower() {
        System.out.println(carModel + " battery power: " + batteryPowerLevel);
        return 100.0;
    }

    // ── CarInterface ──
    @Override
    public void accelerate() {
        System.out.println(carModel + " accelerating silently...");
    }

    // ── AbstractCar ──
    @Override
    public void applyBreak() {
        System.out.println(carModel + " brake applied, battery charging via regeneration...");
    }

    @Override
    protected void openAirBag() {
        System.out.println(carModel + " airbag deployed!");
    }
//getter and setter
    public String getBatteryPowerLevel() {
        return batteryPowerLevel;
    }

    public void setBatteryPowerLevel(String batteryPowerLevel) {
        this.batteryPowerLevel = batteryPowerLevel;
    }

    public int getBatteryCount() {
        return batteryCount;
    }

    public void setBatteryCount(int batteryCount) {
        this.batteryCount = batteryCount;
    }

    public boolean isBatteryCharged() {
        return isBatteryCharged;
    }

    public void setBatteryCharged(boolean batteryCharged) {
        isBatteryCharged = batteryCharged;
    }
}
