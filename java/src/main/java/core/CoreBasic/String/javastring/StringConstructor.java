package core.CoreBasic.String.javastring;

public class StringConstructor {
    public static void main(String[] args) {
        //1. empty
        String s1 = new String();//empty string
        System.out.println(s1);
        s1 = new String("");
        System.out.println(s1);// empty string

        //2. literal in constructor
        String s2 = new String("hello");
        System.out.println(s2);

        String s3 = "rupesh";// SCP --> rupesh
        String s4 = new String(s3);//heap--> rupesh

        //3. char array in constructor
        char[] password = {'9','3','2','r','k','t'};
        String s5 = new String(password);
        System.out.println(s5);

        char[] fullName = {'r','u','p','e','s','h',' ','t','h','a','p','a','l','i','y','a'};
        System.out.println(fullName);

        String firstName = new String(fullName,0,6);//offset: starting. count: desired number of char.
        System.out.println(firstName);

        //4. byte array in constructor -> offset and count can be used.
        byte[] arr = {74,97,118,97};
        String s6 = new String(arr);
        System.out.println(s6);//Java

        //5. StringBuilder in constructor
        StringBuilder sb = new StringBuilder("narayana");
        String s7 = new String(sb);
        System.out.println(s7);

        //6. StringBuffer in constructor
        StringBuffer sb1 = new StringBuffer("kanxa");
        String s8 = new String(sb1);
        System.out.println(s8);


    }
}
