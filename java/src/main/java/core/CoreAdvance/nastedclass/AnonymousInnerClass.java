package core.CoreAdvance.nastedclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Member m1 = new Member();
        m1.introduce();

//        Member m2 = new Guest();
//        m2.introduce();

        //anonymous class do not allowed constructor(must have name as class name) but anonymous itself unnamed.
        Member m2  = new Member(){
            @Override
            public void introduce(){
                greet();// greet can be called inside anonymous class scope.
                System.out.println("I am Guest");
            }
            //final or effectively final required
            final String name = "Rupesh";
            public void greet(){
                System.out.println("hello "+ name);
            }

        };
        m2.introduce();
        //m2.greet();reference m2 dont have greet() method on it, so compile error => basic polymorphism



    }

}
class Member {
    public void introduce(){
        System.out.println("I am member.");
    }
}
//class Guest extends  Member{
//    @Override
//    public void introduce(){
//        System.out.println("I am Guest");
//    }
//}
