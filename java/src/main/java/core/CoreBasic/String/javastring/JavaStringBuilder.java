package core.CoreBasic.String.javastring;

public class JavaStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Lover");
        System.out.println(sb);

        stringBuilderConstructors();

        System.out.println("METHOD AREA STARTED FROM HERE =>");
        stringBuilderAndStringBufferMethod();


    }
    public static void stringBuilderConstructors(){
        //1. initial capacity : 16, value: 0
        StringBuilder sb = new StringBuilder();

        //2. initial capacity : 50 , value : 0
        StringBuilder sb1 = new StringBuilder(50);

        // 3. Literal Constructor: initial capacity = 16 + literal.length()
        StringBuilder sb2 = new StringBuilder("StringBuilder constructor(LITERAL)");
        System.out.println("sb2 length: "+sb2.length());//34
        System.out.println("sb2 capacity: "+sb2.capacity());//50

    }
    //all methods are synchronized in StringBuffer => thread safe,StringBuilder fast(no extra synchronized process)
    // most of the time we use StringBuilder instead of StringBuffer during programming(thread-safe overhead makes slow)
    public static void stringBuilderAndStringBufferMethod(){
        StringBuilder kanxo = new StringBuilder();

        //append() -> at last
        kanxo.append("Rupesh");
        kanxo.append(" Thapaliya Maharaj ji");
        System.out.println(kanxo);

        //insert() --> at position
        kanxo.insert(0,"Mr. ");//shifts old value at index 0 to index 4.
        System.out.println(kanxo.toString());

        //delete()--> substring
        kanxo.delete(24,kanxo.length()-1);
        System.out.println(kanxo);

        //deleteCharAt() --> at position
        kanxo.deleteCharAt(24);
        System.out.println(kanxo);

        //replace --> replace substring
        kanxo.replace(21,24,"ALTER SMART");
        System.out.println(kanxo);

        //reverse --> reverse the given string
        StringBuilder testReverse = new StringBuilder("REVERSE");
        System.out.println(testReverse.reverse());

        //charAt() and setCharAT()
        System.out.println(testReverse.charAt(1));
        testReverse.setCharAt(0,'W');
        System.out.println(testReverse);

        //length() and capacity()
        System.out.println(testReverse.length());//7
        System.out.println(testReverse.capacity());//23
        testReverse.append("huhahuhah");
        System.out.println(testReverse.length());//16
        System.out.println(testReverse.capacity());//23

        testReverse.append("ahuhaha");
        System.out.println(testReverse.length());//23
        System.out.println(testReverse.capacity());//23

        testReverse.append("ahuhaha");
        System.out.println(testReverse.length());//30
        System.out.println(testReverse.capacity());//48

        //ensureCapacity() --> ensures minimum capacity
        testReverse.ensureCapacity(100);
        //// checks if (48 * 2 + 2) < 100
        //// If YES (98 < 100) -> sets 100
        //// If NO   -> sets 98
        System.out.println(testReverse.length());//30
        System.out.println(testReverse.capacity());//100

        //trimToSize() --> removes all empty memory( i.e. I don't want to store more string on StringBuilder
        // mutable object.)
        testReverse.trimToSize();
        System.out.println(testReverse.length());//30
        System.out.println(testReverse.capacity());//30

        //StringBuilder to String => famous toString() method
        // both dont override equals() method => consequences
        StringBuilder sb1 = new StringBuilder("Temal");
        StringBuilder sb2 = new StringBuilder("Temal");
        System.out.println(sb1.equals(sb2));//false, because of reference compare

    }
}

