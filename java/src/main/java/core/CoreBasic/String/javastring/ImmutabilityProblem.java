package core.CoreBasic.String.javastring;

public class ImmutabilityProblem {
    public static void main(String[] args) {
        String s = "";
        for(int i = 0;i<5;i++){
            s = s + i;//new reference(new object in heap)  for s in each loop.
            System.out.println(s);
        }
        System.out.println(s);//last updated reference's value of s, i = 0-3 object are deference
    }
}
