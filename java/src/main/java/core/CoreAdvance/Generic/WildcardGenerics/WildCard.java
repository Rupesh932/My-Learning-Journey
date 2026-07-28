package core.CoreAdvance.Generic.WildcardGenerics;

import java.util.ArrayList;
import java.util.List;

// <?>
public class WildCard {
    public static void main(String[] args) {
        List<MyDog> dogs = new ArrayList<>();
        dogs.add(new MyDog());
        dogs.add(new MyDog());
        dogs.add(new MyDog());
        dogs.add(new MyDog());
        //test(dogs);-> required type MyAnimal, provided MyDog

        List<MyAnimal> animals = new ArrayList<>();
        animals.add(new MyAnimal());
        animals.add(new MyAnimal());
        animals.add(new MyAnimal());
        test(animals);

        System.out.println("**************** WILDCARD TEST STARTS ************************");
        wildcardTest(dogs);
        wildcardTest(animals);

        System.out.println("**************** WILDCARD RULES STARTS ************************");
        wildcardRules(dogs);
        wildcardRules(animals);
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(40);
        intList.add(30);
        wildcardRules(intList);

        System.out.println("**************** WILDCARD UPPER BOUNDS ************************");
        wildcardUpperBoundTest(dogs);
        wildcardUpperBoundTest(animals);
        // wildcardUpperBoundTest(intList);-> early catch => required type(? extends MyAnimal), provided Integer.
        List<Puppy> puppyList = new ArrayList<>();
        puppyList.add(new Puppy());
        puppyList.add(new Puppy());
        puppyList.add(new Puppy());
        wildcardUpperBoundTest(puppyList);
        List<MyCat> catList = new ArrayList<>();
        catList.add(new MyCat());
        catList.add(new MyCat());
        catList.add(new MyCat());
        wildcardUpperBoundTest(catList);

        System.out.println("**************** WILDCARD LOWER BOUNDS ************************");
        System.out.println("------------TEST - 0---------");
            wildcardLowerBoundTest(animals);
          //  wildcardLowerBoundTest(dogs); -> early catch
        System.out.println("-----------TEST - 1----------");
            wildcardLowerBoundTest1(animals);
           wildcardLowerBoundTest1(dogs);
        System.out.println("----------TEST - 2-----------");

            wildcardLowerBoundTest2(animals);
            wildcardLowerBoundTest2(dogs);
            wildcardLowerBoundTest2(puppyList);
        System.out.println("------------TEST - 3-------------");

            wildcardLowerBoundTest3(animals);
            wildcardLowerBoundTest3(catList);
        System.out.println("-------------------------");

    }

    public static void test(List<MyAnimal> animals) {
        for (MyAnimal a : animals) {
            a.eat();
            a.walk();
        }
    }

    public static void wildcardTest(List<?> list) {
        for (Object obj : list) {
            System.out.println("FROM CLASS: " + obj.getClass().getName());
        }
    }

    //list of MyAnimal or subtype only allowed, MyAnimal is max(upper) possible, or subtype.
    public static void wildcardUpperBoundTest(List<? extends MyAnimal> animals) {
        for (MyAnimal animal : animals) {
            animal.eat();
        }
        ////problem-> not allow to write operation.
        // animals.add(new MyAnimal());
        //animals.add(new Dog());
        // animals.add(new MyCat());
        //// even each new object are MyAnimal or subtype, still java not allowed to write to this list.
        // let we've .add(new Dog() ; statement, what if caller pass list of cat or other subtype ?
        //is it logical to add cat to list of dog? obviously not.
    }

    //minimum bounds is MyAnimal and its super type. now we can perform write operation.
    public static void wildcardLowerBoundTest(List<? super MyAnimal> animals) {
        /// writing
        animals.add(new MyAnimal());
        animals.add(new MyDog());
        animals.add(new MyCat());
        animals.add(new Puppy());
        //animals.add(new Integer(20));-> early catch

        ///reading
        for(Object obj : animals){
            System.out.println("FROM CLASS: "+obj.getClass().getName());
            MyAnimal a = (MyAnimal)obj;
            a.eat();
        }

    }

    public static void wildcardLowerBoundTest1(List<? super MyDog> dogs) {
        //dogs.add(new MyAnimal());
        //dogs.add(new MyCat());-> required ? super MyDog, provided MyCat
        dogs.add(new MyDog());
        dogs.add(new Puppy());

        ///reading
        for(Object obj: dogs){
            System.out.println("FROM CLASS: "+obj.getClass().getName());
        }
    }

    public static void wildcardLowerBoundTest2(List<? super Puppy> puppies) {

        //puppies.add(new MyDog());-> early catch
        puppies.add(new Puppy());

        ///reading
        for(Object obj: puppies){
            System.out.println("FROM CLASS: "+obj.getClass().getName());
        }
    }
    public static void wildcardLowerBoundTest3(List<? super MyCat> cats) {

               //cats.add(new Puppy());
        cats.add(new MyCat());

        ///reading
        for(Object obj: cats){
            System.out.println("FROM CLASS: "+obj.getClass().getName());
        }
    }

    public static void wildcardRules(List<?> list) {
        ////1. not allow to write.
        //list.add(10);
        //list.add(new Dog());
        //list.add(new Animal());

        ////2. only read via Object class( parent of all)
        Object obj = list.get(1);// be aware of IndexOutOfBoundsException

        System.out.println("FROM CLASS: " + obj.getClass().getName());

        if (obj instanceof MyDog d) {
            System.out.print("DOG:");
            d.bark();
        } else if (obj instanceof MyAnimal a) {
            System.out.print("ANIMAL:");
            a.eat();
        } else if (obj instanceof Integer i) {
            System.out.println(i * i);
        } else if (obj instanceof String s) {
            s = s.toUpperCase();
            s += " hello";
            System.out.println(s);
        } else {
            System.out.println("WHO IS THIS ? ");
            ;
        }
    }

}

class MyAnimal {
    public void eat() {
        System.out.println("ANIMAL EATING");

    }

    public void walk() {
        System.out.println("walking");
    }
}

class MyDog extends MyAnimal {
    @Override
    public void eat() {
        System.out.println("ANIMAL <-- DOG : EATING");
    }

    public void bark() {
        System.out.println("DOG Barking(hhaauu hhaauu hhaauu hhaauu");
    }
}

class Puppy extends MyDog {
    @Override
    public void eat() {
        System.out.println("ANIMAL <-- DOG <-- PUPPY : EATING");
    }

    @Override
    public void bark() {
        System.out.println("DOG<--PUPPY : Barking(hau hau");
    }
}

class MyCat extends MyAnimal {
    @Override
    public void eat() {
        System.out.println("ANIMAL <-- CAT  : EATING");
    }
}
