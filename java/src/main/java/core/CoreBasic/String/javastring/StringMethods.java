package core.CoreBasic.String.javastring;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        String testString = "   [ID:932-RKT]  Name: Rupesh Thapaliya | Role: Lead Java Developer | Status: Active | " +
                "Tech: Java,Spring,Microservices | Joined: 2026-05-22   ";


        //1.emptyness / length
        System.out.println(testString.isEmpty());
        System.out.println(testString.isBlank());// added at java 11.for blank string i.e. "     ".
        System.out.println(testString.length());

        //2. character access
        System.out.println(testString.charAt(4));
        char[] charArr = testString.toCharArray();
        System.out.println(charArr);

        //3. comparison => we need two string
        String testString1 = "My name is sila , sila ko jawani ";
        System.out.println(testString.equals(testString1));
        String s1 = new String("abc");
        String s2 = new String("adc");
        System.out.println(s1.compareTo(s2));//lexicographical comparison of unicode : negative(66-68) = -2) , 0 or positive value.

        //4. searching
        System.out.println(testString.contains("Rupesh"));
        System.out.println(testString.indexOf("R"));

        //5. transformation / extraction
        System.out.println(testString.substring(11,55));//[11,55)
        System.out.println(testString.trim());
        System.out.println(testString.strip());// unicode friendly
        System.out.println(testString1.repeat(3));

        System.out.println(s1.replace("a","A"));

        System.out.println(testString1.replace("i","by"));

        System.out.println(testString.replace("|","-"));
        //replaceAll
        System.out.println("replace all starts: ");
        System.out.println(testString.replaceAll("\\s","->"));//space
        System.out.println(testString.replaceAll("\\d","*"));//decimal number
        System.out.println(testString.replaceAll("[^A-Za-z]",""));//alphabet only, ^-> not
        System.out.println("replace all ends: ");


        System.out.println("split based on |");
        String[] splitArray = testString.split("\\|");
        for(String s : splitArray){
            System.out.println(s);

        }

        System.out.println("join by #");
        System.out.println( String.join("#",splitArray));

        //conversion
        String s3 = new String(String.valueOf(10));
        System.out.println(s3);
        String s4 = "Rupesh Thapaliya";
        byte[] s4Byte = s4.getBytes();
        for(byte b : s4Byte){
            System.out.print(b+"("+(char)b+") ");
        }
        System.out.println();

        //advance --> intern(), format()
        String s5 = new String("Rupesh");
        String s6 = s5;// same heap reference
        System.out.println(s5 == s6);//true
         String s7 = new String("Pepsicola");// s7--> heap
        String s8 = s7.intern();//s8--> scp
        System.out.println(s7 == s8);//false

        String name = "Bhushan";
        int age = 43;
        System.out.println("hello "+name+", "+"your age is: "+age);
        System.out.println(String.format("hello %s, your age is : %s",name,age));
        System.out.printf("hello %s, your age is : %s",name,age);

    }
}
