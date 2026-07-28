package core.CoreAdvance.nastedclass;

public class StaticNested {
    public static void main(String[] args) {
        Outer outer = new Outer(12);
        Outer.Inner inner =  new Outer.Inner(outer);

        Outer.staticAccessor();
        outer.bothAccessor(outer);

        Outer.Inner.staticAccessor();
        inner.bothAccessorViaConstructor();
        inner.bothAccessorViaParameter(outer);

        //************
        System.out.println( BankAccount.calculateInterest());

    }
}
class Outer{
    static int x;
    private static int y;
    int z;
    public Outer(int z){
        this.z = z;
    }
    public static void staticAccessor(){
        System.out.println("X: "+x+" Y: "+y+" Z: non static context is not accessible in static context");
    }
    public void bothAccessor(Outer outer){
        System.out.println("Z: "+ outer.z);
        System.out.println("X: "+x);
        System.out.println("Y: "+y);
    }
    //********************
    static class Inner{
        {
            x = 22;
            y = 33;
        }
        Outer outer;
        public Inner(Outer outer){
            this.outer = outer;
        }
        public static void staticAccessor(){
            System.out.println("X: "+x+" Y: "+y+" Z: non static context is not accessible in static context");
        }
        public void bothAccessorViaConstructor(){
            System.out.println("Z: "+ outer.z);
            System.out.println("X: "+x);
            System.out.println("Y: "+y);
        }
        public void bothAccessorViaParameter(Outer outer1){
            System.out.println("Z: "+ outer1.z);
            System.out.println("X: "+x);
            System.out.println("Y: "+y);
        }
    }
}
class BankAccount{
    static double principle ;
    static double yRate;
    static double hyRate;
    static double qRate;
    static{
        principle = 40000;
        yRate = 0.10;
        hyRate = 0.045;
        qRate = 0.02;
    }
    private static class InterestCalculator{


        static double calculateYearly(double principle,double rate){
            return principle * rate;
        }
        static double calculateHalfYearly(double principle,double rate){
            return principle * rate;
        }
        static double calculateQuartly(double principle, double rate){
            return  principle * rate;
        }
    }
    public static String calculateInterest(){
        double yearlyInterest =  InterestCalculator.calculateYearly(principle,yRate);
        double halfYearlyInterest = InterestCalculator.calculateHalfYearly(principle,hyRate);
        double quarterlyInterest =  InterestCalculator.calculateQuartly(principle,qRate);
        return (" YINTEREST: "+yearlyInterest+", HYINTEREST: "+ halfYearlyInterest+" QINTEREST: "+quarterlyInterest);
    }
}
