package core.CoreAdvance.nastedclass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        System.out.println(outer.name);
        Outer1.Inner1 inner = outer.new Inner1();
        System.out.println(inner.name);
        inner.fun();
        //one liner but outer has not reference
        Outer1.Inner1 inner1 = new Outer1().new Inner1();
        Outer1.Inner1.printName();
    }
}
class Outer1{
      String name = "outer";
    class Inner1{
        String name = "inner";
        public void fun(){
            System.out.println("hello fun");
            System.out.println("Outer name: "+Outer1.this.name);
            System.out.println("Inner name: "+this.name);
            System.out.println("Inner name: "+name);


        }
        //java 16 onwards static member(variables, methods(main() also),blocks) are allowed
        public static String innerName= "static inner variable";
        static{
            System.out.println("static block of non-static inner class, possible from java 16.");
        }
        public static void printName(){
            System.out.println("static inner method accessing "+innerName);

        }

    }

}
