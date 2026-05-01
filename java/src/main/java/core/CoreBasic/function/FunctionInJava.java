package core.CoreBasic.function;

public class FunctionInJava {
    public static void main(String[] args) {
        System.out.println("sum: " + add(33, 55));
        System.out.println("sum: " + add(add(355, 887), 333, 5542, 400));
        System.out.println("sum: " + add(2579, 7699, 500, 44, 23, 67));
        // -----------------------------------------------
        recursivePrint(10);
        System.out.println();
        // ------------------------------------------------
        System.out.println("5th term of fibonacci " + fib(5));
        System.out.println("10th term of fibonacci " + fib(10));
        System.out.println("11th term of fibonacci " + fib(11));
        System.out.println("12th term of fibonacci " + fib(12));
        // ------------------------------------------------
        

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int... args) {
        int sum = 0;
        for (int value : args) {
            sum += value;
        }
        return sum;
    }

    // recustion
    // print 1 - 10 using recursion
    public static void recursivePrint(int n) {
        if (n < 1) {
            return;
        }

        recursivePrint(n - 1);
        System.out.print(n + " ");

    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int x = fib(n - 1);
        int y = fib(n - 2);
        return x + y;

    }
}
