package core.CoreBasic.interfaceinjava;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;

public class VariablesInInterface {
    public static void main(String[] args) {
        MathConstant constant = new Random();
        constant.fixValue();

        //variable access
        System.out.println("PI: "+MathConstant.PI_VALUE);

    }
}
interface MathConstant{
    //static constant allowed by default public(for each method also) static and final
    //in-fact we will have collection of constant value in interface in production
    public static final double  PI_VALUE = 22/7d;
    int MIN_INTEGER = Integer.MIN_VALUE;
    int MAX_INTEGER = Integer.MAX_VALUE;

    void fixValue();
}
class Random implements MathConstant{
    @Override
    public void fixValue(){
        System.out.println("PI: "+PI_VALUE);
        System.out.println("MIN INT: "+MIN_INTEGER);
        System.out.println("MAX INT: "+MAX_INTEGER);
    }
}
