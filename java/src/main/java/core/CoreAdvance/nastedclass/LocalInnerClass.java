package core.CoreAdvance.nastedclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Example example = new Example();
        example.print();

        example.methodInnerPrint();

    }
}
class Example{
    String name = "EXAMPLE CLASS =>";
    public void print(){
        System.out.println(name+"  member :  'print()' method.");
    }
    public void methodInnerPrint(){
        String methodName = "methodInnerPrint()";
        System.out.println(name+" member : 'methodInnerPrint()' method");
        // local inner class inside method, it can extend, implements other class and interfaces.
            class InsideMethod{
                {
                    System.out.println("*** LOCAL INNER CLASS INFO ***");
                    System.out.println("Local Inner class is executing, its instance block");
                    System.out.print("OUTER CLASS: ");
                    print();
                    System.out.println("INSIDE METHOD:  "+ methodName);
                }
                //final or effectively-final(no update ) rule.
                final String localName = InsideMethod.class.getName();
                int x = 5;
                //x++; -> can't modify(effectively final)
                public void printLocalInner(){
                    System.out.println("INSIDE CLASS : "+ localName);
                    System.out.println("*** ENDED.***");

                }

        }
        InsideMethod localInner = new InsideMethod();
            localInner.printLocalInner();

    }

}
