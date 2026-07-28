package core.CoreAdvance.lamdas.functionalcomposition;

import java.util.function.Function;

public class AndThen {
    public static void main(String[] args) {
        //( ((x+2) * 3)

        // LE of equation
        Function<Integer,Integer> equation = x -> (x + 2) * 3;
        Integer result = equation.apply(2);
        System.out.println(result);

        //breakdown
        Function<Integer,Integer> add2 = x -> x + 2;//f(x)
        Function<Integer,Integer> multiply3 = x -> x * 3;//g(x)
        Function<Integer,Integer> divide2 = x -> x / 2;//g(x)
        Function<Integer,Integer> subtract1 = x -> x - 1;//g(x)

        int ans = add2.apply(2);
        int ans2 = multiply3.apply(ans);
        System.out.println(ans2);

        int ans3 = multiply3.apply(add2.apply(2));//g(f(x))
        System.out.println(ans3);

        //g(f(x)) -> java approach
        int bestAns = add2
                .andThen(multiply3)
                .andThen(divide2)
                .andThen(subtract1)
                .apply(2);
        System.out.println(bestAns);


    }
}
