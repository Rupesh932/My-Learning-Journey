package core.CoreAdvance.Generic;

public class UpperBounds1 {
    public static void main(String[] args) {

        UpperBoundTest<Fish> fishTest = new UpperBoundTest<>();

        UpperBoundTest<MyDog> dogTest = new UpperBoundTest<>();

        //UpperBoundTest<Mouse> mouseTest = new UpperBoundTest<>();-->compile error, Mouse is not swimmable

        //UpperBoundTest<Bird> birdTest = new UpperBoundTest<>();-->compile error, Bird  is not swimmable

        UpperBoundTest<Puffin> puffinTest = new UpperBoundTest<>();

    }
}
// Standard way => T extends class & interface1,interface2,...(no need to use implements keyword for interface here)
class UpperBoundTest<T extends MyAnimal & Swimmable>{
        T value;


}
interface Flyable{
    boolean AERODYNAMIC = true;
    void fly();


}
interface Swimmable{
    boolean HYDRODYNAMIC = true;
    void swim();
}
class MyAnimal{
    public void display(){
        System.out.println("Displaying Animal");
    }
}
class MyDog extends MyAnimal implements Swimmable{
    @Override
    public void swim(){
        System.out.println("dog: Swimming");
    }
}
class Mouse extends MyAnimal{

}
class Fish extends MyAnimal implements Swimmable{
    @Override
    public void swim(){
        System.out.println("Fish: swimming");
    }
}
 abstract class Bird extends MyAnimal implements Flyable{

     @Override
     public void fly() {
         System.out.println("Birds: flying");
     }
 }
 abstract class HunterBird extends Bird{
    abstract void hunt();
 }
 class Eagle extends HunterBird{

     @Override
     void hunt() {
         System.out.println("Eagle : hunting pray");
     }
 }
 abstract class prayBird extends Bird{
    abstract void huntedBy();
 }
 class Pigeon  extends prayBird{

     @Override
     void huntedBy() {
         System.out.println("Pigeon hunted by hunter");
     }
 }
 class Puffin extends HunterBird implements Swimmable{

     @Override
     void hunt() {

     }

     @Override
     public void swim() {

     }
 }

