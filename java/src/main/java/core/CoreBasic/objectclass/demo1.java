package core.CoreBasic.objectclass;

public class demo1 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        System.out.println(a.getClass().getName());// animal
        System.out.println(d.getClass().getName());// dog

        System.out.println(a instanceof Animal);// true
        System.out.println(a instanceof Dog);// false
        System.out.println(a instanceof Object);// true

        System.out.println(d instanceof Animal);// true
        System.out.println(d instanceof Dog);// true
        System.out.println(d instanceof Object);// true
        System.out.println(null instanceof Object);//false(instance of always return false for null(i.e.not instance of any class))
        //जाभाको नियम अनुसार null को कुनै Type हुँदैन, त्यसैले यो कुनै पनि क्लासको इन्स्ट्यान्स हुन सक्दैन।
    }
}

class Animal {

}

class Dog extends Animal {

}
