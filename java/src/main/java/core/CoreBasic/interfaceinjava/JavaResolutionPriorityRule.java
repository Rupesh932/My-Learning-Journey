package core.CoreBasic.interfaceinjava;

public class JavaResolutionPriorityRule {
    public static void main(String[] args) {
        A c = new C();
        c.fun();// inside B, priority for class is high

        A d = new D();
        d.fun();//inside D
    }
}
interface  A{
    default void fun(){
        System.out.println("Inside A");
    }
}
class B{
    public void fun(){
        System.out.println("Inside B");
    }
}

class C extends B implements A{
    //if C is not overrides fun(), c object always has class method (i.e. fun() of B)
}
class D extends B implements A{
    @Override
    public void fun(){
        System.out.println("Inside D");
    }
}
