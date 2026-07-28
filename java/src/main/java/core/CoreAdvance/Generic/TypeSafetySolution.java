package core.CoreAdvance.Generic;

public class TypeSafetySolution {
    public static void main(String[] args) {
        genericBoxManipulator();

        pairManipulation();

    }
    public static void genericBoxManipulator(){
        //type argument(provided)
        GenericBox<Integer> intBox = new GenericBox<Integer>(10);
        int a = intBox.getValue();
        System.out.println("VALUE : "+a * a);

        GenericBox<String> stringBox = new GenericBox<String>("hello");
        String s = stringBox.getValue();
        System.out.println("VALUE : "+s.toUpperCase());

       // String ss = (String)intBox.getValue(); -> early catching no need to wait till runtime
    }
    public static void pairManipulation(){
        Pair<String,Integer> nameIdPair = new Pair<>("Rupesh",102);
        System.out.println("Name:"+nameIdPair.getFirst()+", Id: "+nameIdPair.getSecond());
        Pair<Integer,Integer> salaryAndTaxPair = new Pair<>(65000,1500);
        System.out.println("Salary:"+salaryAndTaxPair.getFirst()+", Tax: "+salaryAndTaxPair.getSecond());

    }
}
//typed parameter(expected)
class GenericBox<T>{
    private T value;

    public GenericBox(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }

}
class Pair<T,U>{
    private T first;
    private U second;

    public Pair(T first,U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){return first;}
    public void setFirst(T first){this.first = first;}

    public U getSecond(){return second;}
    public void setSecond(U second){this.second = second;}
}
