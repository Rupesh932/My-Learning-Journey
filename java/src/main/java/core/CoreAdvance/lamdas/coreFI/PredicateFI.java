package core.CoreAdvance.lamdas.coreFI;

import java.util.function.Predicate;

public class PredicateFI {
    //takes input, return boolean : test on input
    public static void main(String[] args) {
        Predicate<String> test = (name)-> name == null || name.isEmpty() || name.isBlank() ;
        System.out.println(test.test("Rupesh Thapaliya"));

        PredicateInterface<Integer> testEven = (x)-> x % 2 == 0;
        System.out.println(testEven.test(11));
    }
}
interface PredicateInterface<T>{
    boolean test(T t);
}
