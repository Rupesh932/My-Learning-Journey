package core.CoreAdvance.Generic;

public class BoundedGeneric {
    public static void main(String[] args) {
        UpperBoundBox<Number> num = new UpperBoundBox<>(10);
        num.printDouble();
        UpperBoundBox<Integer> i = new UpperBoundBox<>(10);
        i.printDouble();
        UpperBoundBox<Double> d = new UpperBoundBox<>(10.0);
        d.printDouble();
        // UpperBoundBox<String> ub3 = new UpperBoundBox<>("hello vai");--> String is not a Number or subtype


    }
}

class UnBoundedBox<T> {
    T value;

    public void printDouble() {
        //System.out.println(value.getDouble()); -> we can only call object's method
        // till now jvm doesn't know type of value hence no other method could be called over value.
        System.out.println("hash value: " + value.hashCode());
    }
}

//Bounds in generic => 1. upper bound and  2. lower bounds
//1. upper bounds ( now T should  Number or its subtype)
class UpperBoundBox<T extends Number> {
    T value;

    public UpperBoundBox(T value) {
        this.value = value;
    }

    public void printDouble() {
        System.out.println(value.doubleValue());
    }
}
