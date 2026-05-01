package dsa.basic;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(9));

    }
    public static boolean isArmstrong(int number){
         int original = number;
        int digitsInNumber = count(number);
        int sum = 0;
        while(number > 0){
            int digit = number  %  10;
            sum += power(digit,digitsInNumber);
            number /= 10;
        }
        return (original == sum);
    }
    
    public static int count(int number){
        if(number == 0){
            return 1;
        }
        int count = 0;
        int absNum = Math.abs(number);
        while(absNum > 0){
            absNum /= 10;
            count ++;
        }
        return count;
    }
    public static int power(int base,int exponent){

        if(exponent <= 1 ){
            return (exponent == 1) ? base : ((exponent == 0) ? 1 : -1) ;
        }
        if(base <= 1){
            return (base == 1) ? 1 : ((base == 0) ? 0 : -1);
        }
        int result = 1;
        while(exponent >= 1){
            result = result * base;
            exponent--;
        }
        return  result;
    }
}
