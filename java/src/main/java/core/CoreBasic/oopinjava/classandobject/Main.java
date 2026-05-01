package core.CoreBasic.oopinjava.classandobject;

 class Student {
    int id;
    String name;
    int age;
    String institute;
    String address;
    
}
public class Main{
    public static void main(String[] args) {
        Student s1  = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.name = "";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        

        
    }
}
class Animal{
    String color;
    double weight;
    int age;
    boolean isDomistic;

    void makeSound(){
        if(isSick()){
            System.out.println(this+" sound seems paining");
           
        }else{
             System.out.println(this+" is making good sound");
        }

    }
    void eat(String food){
        System.out.println(this+" is eating "+food);
    }
    void walk(){
        if(isSick()){
            System.out.println(this+"  can walk slowly");
        }else{
            System.out.println(this+" can run ");
        }

    }
    boolean isHungry(int foodNotFoundInHours){
         if(foodNotFoundInHours >= 12){
            return true;
         }
         return false;
    }
    boolean isSick(){
        int  notEatenDays = 2;
        if(isHungry(10) && notEatenDays >= 2){
            return true;
        }
        return false;
    }



}


