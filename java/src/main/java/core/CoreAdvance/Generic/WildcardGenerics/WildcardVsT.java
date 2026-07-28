package core.CoreAdvance.Generic.WildcardGenerics;

public class WildcardVsT {
    //1. use wildcard to generic container like list
}
class Test1<T>{
    //? value; not allow even in type parameter.
    T value;

    public static<T> void fun(T a,T b){
        // not allow to replace T with wildcard.
    }
}
