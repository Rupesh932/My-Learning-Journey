package dsa.util;

public class Factorial {


    public static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);

    }
}


