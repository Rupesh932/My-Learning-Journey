package core.CoreBasic.interfaceinjava.diamondproblem;


//multiple inheritance through interface
public class DiamondProblemSolved {
    public static void main(String[] args) {
        // object of MITI ( direct child of Y and Z , indirect child of X)
        X x = new MultipleInheritanceThroughInterface();
        x.fun();
        System.out.println("sad mood detection: ");
        for(int i = 0;i<5;i++){
            x.sad();
        }



    }
}
interface X{
    void fun();
    default  void sad(){
        System.out.println("x(grandparent): sad mood");
    }
}
interface Y extends X{
   @Override
     default void sad(){
       System.out.println("y(parent): sad mood");
   }
   default void grandParentSad(){
       X.super.sad();
   }
}
interface  Z extends X{
    @Override
    default void sad(){
        System.out.println("Z(parent): sad");
    }
}
class MultipleInheritanceThroughInterface implements Y,Z{

    @Override
    public void fun() {
        System.out.println("one implementation, no confusion");
    }

    @Override
    public void sad() {
        char value =(char) ((int)(Math.random() * 3) + 120);
        char lower = Character.toLowerCase(value);

        if(lower== 'y'){
            Y.super.sad();
        }else if( lower== 'z'){
            Z.super.sad();
        }else if(lower == 'x'){
           Y.super.grandParentSad();
        }

        /*
        Y.super.sad() or Z.super.sad() : internal execution mechanism
          1. Who is calling this.sad()? -> The actual MITI Object in the Heap.
          2. MITI is a direct child of Y and Z, which creates the Diamond Conflict.
          3. Y.super and Z.super both grammatically target their common ancestor X.
          4. Compiler forces us to use 'InterfaceName.super' to clear ambiguity.
          5. At Runtime: Y.super.sad() resolves to Y's body because Y has overridden X's method
             (Dynamic Method Dispatch follows the most specific overridden version in that branch).
          6. Z.super.sad() resolves to Z's body because Z has overridden X's method.
          7. Plain 'super.sad()' is illegal here and causes compile error; explicit qualifier is mandatory.
          8. This explicit branch selection via Y.super / Z.super is the official way to solve the diamond problem in Java.
*/



    }
}
