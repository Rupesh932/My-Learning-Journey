package core.CoreAdvance.Generic;

public class TypeSafetyAndProblems {
    public static void main(String[] args) {
        // upcasting
        int x = 20;
        long test1 = x;


        String s = "hello";
        Object test2 = s;

        Animal a = new Dog();

        //down casting
        long l2 = 33l;
        int test3 = (int)l2;

        Object obj = "hello hello";
        String test4 = (String)obj;

       Object i = 10;//auto boxing i.e. Integer
       try{
           String test5 = (String)i;//ClassCastException
       }catch(ClassCastException e){
           System.out.println("Exception during cast: "+e.getMessage());
       }


    }

    public static void classBoxManipulation(){
        Box intBox = new Box(10);
        Box floatBox = new Box(3.4f);
        Box stringBox = new Box("hello");
        Box booleanBox = new Box(false);
        Box chrBox = new Box('Y');

        //problems : compile error
           //int a = intBox.getValue()+5;-> object + 5 => no sense.
          //float f = floatBox.getValue()+4.4;
          //stringBox.getValue()+" hello"; -> object + "hello" => no sense
          //stringBox.toUppecase();-> object.toUppercase() not defined.
        //// object class is too generic, we ae facing the type information loss causes what operation could be performed
        //// on value is uncleared.
        //SOLUTION : DOWN CASTING -> manual hell, high chance of ClassCastException like in your try block code.
        int a = (Integer) intBox.getValue();
        float f = (Float)floatBox.getValue();
        String s = (String)stringBox.getValue();
        boolean b = (Boolean)booleanBox.getValue();
        char c = (Character)chrBox.getValue();
        //// again developer wants bugs at compile time instead of waiting to run time.
    }
}
class Animal{

}
class Dog extends Animal{

}
//non generic  problem demo
class IntBox{
    private int value;
    public IntBox(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}
class FloatBox{
    private float value;
    //constructor,getter,setter
}
class StringBox{
    private String value;
    //constructor,getter,setter
}
class ShortBox{
    private short value;
    //constructor,getter,setter
}
// more or we need to design a class for each type
//  what if we could design a class that could take any type
class Box{
    private Object value ;
    public Box(Object value){
        this.value = value;
    }
    public Object getValue(){
        return value;
    }
    public void setValue(Object value){
        this.value = value;
    }
    // now Box  intBox = new Box(10); booleanBox = new Box(false);... should be possible.but ... see manipulation()
}