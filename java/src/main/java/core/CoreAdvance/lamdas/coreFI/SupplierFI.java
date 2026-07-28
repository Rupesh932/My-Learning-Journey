package core.CoreAdvance.lamdas.coreFI;

import java.util.function.Supplier;

public class SupplierFI {
    //supply only , not input
    public static void main(String[] args) {
        Supplier<String> supply = ()->"Rupesh";
        System.out.println("name: "+ supply.get());

        SupplierInterface<Integer> random = ()->(int) (Math.random() * 10) ;
        System.out.println(random.get());
    }


}

interface SupplierInterface<T>{
    T get();
}
