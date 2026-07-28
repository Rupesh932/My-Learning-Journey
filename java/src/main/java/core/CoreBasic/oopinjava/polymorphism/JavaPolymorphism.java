package core.CoreBasic.oopinjava.polymorphism;

import core.CoreBasic.wrapperclass.MyInteger;

public class JavaPolymorphism {
    //1. method overloading(compile time polymorphism)
    //2. method overriding(run time polymorphism)
    static Animal all;
    public static void main(String[] args) {
       
        Animal human = new Human();
        human.run();

        Animal dog = new Dog();
        dog.run();

        Animal eagle = new Eagle();
        eagle.run();
        ((Eagle)eagle).fly();

        Animal fish = new FlyingFish();
          fish.run();


          if(all instanceof Human h){

             h.run();
          }else if(all instanceof  Dog d){

              d.run();
          }else if (all instanceof  Eagle e){

              e.run();
          }else if(all instanceof FlyingFish f){

              f.run();
          }else{
              all = null;
          }
    }
}
interface Swimable{
    void swim();
}
interface Flyable{
    void fly();
}
abstract class Animal{

    abstract void run();
}
class Human extends Animal{
    @Override
    void run() {
        System.out.println("human is running at 12km/h");
    }
}
class Dog extends Animal implements Swimable{
    @Override
    void run(){
        System.out.println("dog is running at 30km/h");
    }

    @Override
    public void swim() {
        System.out.println("dog can swim naturally");
    }
}
class Eagle extends Animal implements Flyable,Swimable{

    @Override
    void run() {
        System.out.println("eagle is running at 20km/h in ground ");
    }

    @Override
    public void fly() {
        System.out.println("eagle is flying king in the sky");
    }

    @Override
    public void swim() {
        System.out.println("eagle can swim with fish in mouth");
    }
}
class FlyingFish extends Animal implements Swimable,Flyable{

    @Override
    void run() {
        System.out.println("fish can run under water at high speed");
    }

    @Override
    public void fly() {
        System.out.println("This fish can fly over 5 minutes over water surface");
    }

    @Override
    public void swim() {
        System.out.println("Fish are capable to swim, and breath under water");
    }
}