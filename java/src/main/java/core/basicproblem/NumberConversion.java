package core.basicproblem;

public class NumberConversion {

    public  long decimalToBinary(int num){
        if(num < 1){
            return (num == 0) ? 0:-2;
        }
        if(num >= 1024){
            return -22;
        }

        long ans= 0;
        long mul = 1;
        while(num > 0){
            //int rem = num % 2;
            int rem = num & 1;
            //num = num / 2;
            num = num >> 1;
            ans = ans + rem * mul;// binary(rem) is treating as integer, caused overflow very fast.i.e. 1024
            mul = mul * 10;
        }
        return ans;
    }


    //binary is sequence of 0 and 1 , string is the best idea to hold
  public   String decimalToBinaryStringForm(int num){
        if(num < 1){
            return (num == 0) ? "0" : "invalid input";
        }
        StringBuilder ansBuilder = new StringBuilder();
        while(num > 0){
            int rem = num % 2;
             num = num / 2 ;
             ansBuilder.append(rem);

        }
        return ansBuilder.reverse().toString();

    }
    public  int binaryToDecimal(long num){
        if(num < 1){
            return (num == 0) ? 0: -1;
        }
        int lastDegit;
        int ans = 0;
        int mul = 1;
        while(num > 0){
            lastDegit = (int)(num % 10);
            if(lastDegit != 0 && lastDegit != 1){
                return -11;
            }
            num = num / 10;
            ans = lastDegit * mul + ans;
            mul = mul * 2;
        }
        return ans;
    }



}
