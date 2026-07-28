package core.CoreAdvance.Generic;

public class GenericMethod {
    public static void main(String[] args) {

        Integer i = (Integer)FirstThoughtPrinciple.getResult(11);
        String s = (String)FirstThoughtPrinciple.getResult("hello");
        boolean b = (Boolean)FirstThoughtPrinciple.getResult(false);
        System.out.println(i+", "+s+", "+b);

        System.out.println("************************************");

        int i1 = getResult(20);
        String s1 = getResult("hi n hello");
        boolean b1 = getResult(false);
        System.out.println(i1+", "+s1+", "+b1);

        System.out.println("************************************");
        //type inference=> java detects the type according to argument pass to parameter.
        printPair("Rupesh","Kavre");
        printPair(23,50);
        printPair(false,true);
        printPair("Salary","Taxrate");


    }
    //generic methods
    public static<T> T getResult(T x){
        return x;
    }
    public static<T,U> void printPair(T first,U second){
        System.out.println("First: "+first+", Second: "+second);

    }
    public <T> T hello(T value){
        return value;
    }
}
class FirstThoughtPrinciple{
    public static Object getResult(Object result){
       return result;
    }
}
