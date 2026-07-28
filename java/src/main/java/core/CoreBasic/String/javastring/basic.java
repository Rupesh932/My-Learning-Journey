package core.CoreBasic.String.javastring;

public class basic {
    public static void main(String[] args) {
        char[] myString = {'R','u','p','e','s','h'};
            for(char c : myString){
                System.out.print(c);
            }
        System.out.println();
            //hacked
            myString[0] = 'K';

        for(char c : myString){
            System.out.print(c);
        }
        System.out.println();
        //no built-in methods
        for(int i = 0,j=myString.length-1;i < j;i++,j--) {
            char temp = myString[i];
            myString[i] = myString[j];
            myString[j] = temp;
        }
        for(char c : myString){
            System.out.print(c);
        }
        System.out.println();
        //memory nightmare
        char[] myString1 = {'R','u','p','e','s','h'};
        char[] myString2 = {'R','u','p','e','s','h'};
        char[] myString3 = {'R','u','p','e','s','h'};

          //String for char[]
        String s = "hello";//immutable
        System.out.println("new string with new memory location but no reference:  "+s.concat(" world"));
        System.out.println("original string with reference in stack: "+s);

        String s1 = "hello";
        System.out.println(s.equals(s1));//true
        System.out.println(s == s1);//true

        String s2 = new String("Rupesh");
        String s3 = new String("Rupesh");
        System.out.println(s2 == s3);//false
        System.out.println(s2.equals(s3));//true

        String s4 = "ke" + "ra";//compile time solved
        String s5 = "kera";
        System.out.println(s4 == s5);//true

        String s6 = "ji";
        String s7 = s6 + "ra";//run time solved
        String s8 = "jira";
        System.out.println(s7 == s8);//false

        String s9 = s8;
        System.out.println(s9 == s8);//true

        s9 = "kira";
        System.out.println(s9+" != "+s8);

        String s10 = new String("hello world");
        String s11 = "hello world";
        System.out.println(s10 == s11);//false



    }
}
