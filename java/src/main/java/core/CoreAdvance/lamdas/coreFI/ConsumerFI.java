package core.CoreAdvance.lamdas.coreFI;

import java.util.function.Consumer;

public class ConsumerFI {
    //consume only, not return any

    public static void main(String[] args) {
        Consumer<String> print = (name)-> System.out.println("name: "+name);
        print.accept("Rupesh");
    }
}

interface ConsumerInterface<T>{
    void accept(T t);
}
