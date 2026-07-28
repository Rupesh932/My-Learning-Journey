package core.CoreBasic.interfaceinjava.diamondproblem;

// classic diamond problem in multiple inheritance through class
public class DiamondProblemInJava {
    public static void main(String[] args) {

    }
}

class A {
    public void fun(){
        System.out.println("having fun");
    }
}
class B extends A{
    @Override
    public void fun(){
        System.out.println(" B is having fun via watching movies, boxing, football");
    }
}
class C extends A{
    @Override
    public void fun(){
        System.out.println("C is having fun via social work, seeking helpless people and help them ");
    }
}
// class D extends B,C { }
// D d = new D();
// d.run(): which run form B or from c ? compiler gets confusion