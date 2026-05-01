package core.CoreBasic.variables;

public class variable {
    public static void main(String[] args) {
        float f = 8.125f;
        System.out.println(f);

        System.out.printf("%.20f%n",f);

        f= 0.7f;

         System.out.println(f);

        System.out.printf("%.20f%n",f);//0.69999998807907100000

        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f1 = 5.67f;
        double d = .1234;

        double result = (f1 * b) + (i/c) - (d * s);
          // f1 * b-->  float 
          // i / c --> integer
          // d * s --> double

          // float + integer --> float
          // float - double --> double

          System.out.println((f1 * b) +" + "+ (i/c) +" - "+ (d * s));
          System.out.println("result = "+ result);
    }
}
