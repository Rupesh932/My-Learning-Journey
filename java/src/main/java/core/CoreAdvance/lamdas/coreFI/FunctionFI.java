package core.CoreAdvance.lamdas.coreFI;

import java.util.function.Function;

public class FunctionFI {
    public static void main(String[] args) {
        Function<Integer,Integer>  square = x -> x * x;// override apply method
        int result = square.apply(4);
        System.out.println(result);
    }
}
