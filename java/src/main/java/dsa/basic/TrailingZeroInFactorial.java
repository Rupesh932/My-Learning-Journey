package dsa.basic;

public class TrailingZeroInFactorial {
    public static void main(String[] args) {
        System.out.println(trailingZeroInFactorial(5));

        System.out.println(trailingZeroInFactorial(100));
        System.out.println(trailingZeroInFactorial(150));
        System.out.println(trailingZeroInFactorial(148));
        System.out.println(trailingZeroInFactorial(444));

    }
    public static int trailingZeroInFactorial(int number){
        int count = 0;
        while(number >= 5){
            number /=  5 ;
            count += number;

        }
        return count;
    }
}
