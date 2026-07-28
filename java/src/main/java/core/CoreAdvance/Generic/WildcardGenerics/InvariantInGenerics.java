package core.CoreAdvance.Generic.WildcardGenerics;

import java.util.ArrayList;
import java.util.List;

public class InvariantInGenerics {
    public static void main(String[] args) {
        //normal-> one dog could cast to one animal
        Animal animal = new Dog();

        //Invariant in generics => safe
        List<Dog> dogs = new ArrayList<>();
        //List<Animal> animalList = dogs;--> compiler error(Type mismatch), many dogs could not cast to many animal.

        //co-variant: array => risky
        Dog[] dogArray = new Dog[10];
        Animal[] animalArray = dogArray;// list is generic but array is not, hence compiler allowed to store
        //  dogArray into animalArray.
        dogArray[0] = new Dog();
        dogArray[1] = new Dog();
        dogArray[2] = new Dog();
        animalArray[3] = new Animal();//ArrayStoreException => runtime

        for(Animal a : animalArray){
            if(a == null){
                continue;
            }
            a.eat();
        }
    }


}
class Animal{
    public void eat(){
        System.out.println("Eating");

    }
    public void walk(){
        System.out.println("walking");
    }
}
class Dog extends Animal{
    public void bark(){
        System.out.println("Barking");
    }
}