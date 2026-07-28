package core.CoreAdvance.optional;

import java.util.Optional;

public class OptionalMethods {
    public static void main(String[] args) {

        System.out.println("***************Empty Optional Test****************");
        // System.out.println(getName().get());// exception : NSEE need to check optional is empty or not
        if(getEmptyName().isPresent()){
            System.out.println(getEmptyName().get());
        }
        System.out.println(getEmptyName().orElse("Unknown"));
        //System.out.println(getEmptyName().orElseThrow());// intentionally throwing Exception if needed


        //Supplier LE to orElseGet() method
        System.out.println(getEmptyName().orElseGet(()->"Unknown"));

        //better approach
       Optional<String> name = getEmptyName();
       name.ifPresent(System.out :: println);

        System.out.println("***************Nullable Optional Test****************");
        Optional<String> name1 = getNullableName();
        name1.ifPresent(System.out :: println);
        System.out.println(getNullableName().orElse("Unknown"));
        System.out.println(getOfName().orElse("Unknown"));

        name.ifPresentOrElse(System.out :: println,() -> System.out.println("Unknown"));

        System.out.println("***************of() Optional Test****************");
        Optional<String> name2 = getOfName();
        name2.ifPresent(System.out :: println);
        //ifPresentOrEsle()
        name2.ifPresentOrElse(System.out :: println,() -> System.out.println("Unknown"));


    }

    public static Optional<String> getEmptyName() {
        return Optional.empty();
    }
    public static Optional<String> getNullableName() {
        return Optional.ofNullable(null);
    }
    public static Optional<String> getOfName() {
        return Optional.of("Rupesh");
    }
}
