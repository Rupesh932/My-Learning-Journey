package core.CoreAdvance.lamdas.forEach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod {
    //forEach() -> from Iterable interface

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,0));

        //// collection printing ways :
        //1.simple for loop
        //2. for each loop -> internally Iterator of Iterable is working
        //3. use Iterator
        //4. use forEach() -> takes lamda expression of Consumer type
         // you can pass proper object or lamda expression to this method

        list.forEach((x) -> System.out.print(x+" "));

        //method reference
        System.out.println("======================");
        list.forEach(System.out :: println);
    }
}
interface IterableInterface<T>{
    // lot of code
    default void forEach(Consumer<? super T> action){
        // logic
    }
}
