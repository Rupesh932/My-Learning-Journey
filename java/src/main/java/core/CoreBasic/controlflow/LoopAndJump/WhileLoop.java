package core.CoreBasic.controlflow.LoopAndJump;

public class WhileLoop {
    // loop need: to perform any task repeatedly
    // print 1 10/100/1000... times
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println("*****************");

        int i = 2;
        System.out.println(i);
        System.out.println(i);
        System.out.println(i);
        System.out.println(i);
        System.out.println(i);
        System.out.println("*****************");

        int count = 1;
        while (count <= 10) {
            System.out.print(1 + ", ");
            System.out.print(i + ", ");
            count++;
        }

        System.out.println("\n*****************");
        // print 1 - 5 wihtout loop
        int j = 1;
        System.out.print(j + ",");
        j++;
        System.out.print(j + ",");
        j++;
        System.out.print(j + ",");
        j++;
        System.out.print(j + ",");
        j++;
        System.out.print(j + ",");

        System.out.println("\n*****************");

        // using loop
        j = 0;
        while (j <= 10) {
            System.out.print(j + ",");
            j++;
        }

        System.out.println("\n*****************");
        // optimized
        j = 0;
        while (j++ < 10) {
            System.out.print(j + ",");
        }
        System.out.println("\n*****************");

       
    }
}
