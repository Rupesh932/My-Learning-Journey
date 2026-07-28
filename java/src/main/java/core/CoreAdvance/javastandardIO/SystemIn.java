package core.CoreAdvance.javastandardIO;

import java.io.IOException;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        System.out.println("enter value of x: ");
        int x = System.in.read();
        System.out.println((char) x);
        x = System.in.read();// holds \n to x from buffer.
        System.out.println((char) x);// consume \n

        System.out.println("Enter name: ");// enter Aditya
        int first = System.in.read();// first byte from buffer, i.e A
        int second = System.in.read();// d

        System.out.println((char) first + "" + (char) second);//Ad
        System.out.println(first + second);//65 + 100 = 165

        //via loop
        String s = "";
        int c = -1;
        while (c != '\n') {
            c = System.in.read();// itya -> Ad already consumed.
            s += (char) c;
        }
        System.out.println(s);

        // legacyInput() call
        legacyInput();

    }

    public static void legacyInput() throws IOException {
        String msg = "Enter your name: ";
        System.out.write(msg.getBytes());// write takes int value, not string, so we need to pass bytes of string.also need to call flush()
        System.out.flush();// flush from internal buffer(os level) to java level.
        int data = System.in.read();
        String name = "";
        while (data != '\n') {
            name += (char) data;//string concatenation in loop is too bad
            data = System.in.read();
        }
        String fullMsg = "your name is : " + name;
        System.out.write(fullMsg.getBytes());
        System.out.flush();
        //modern  java print() version internally does:
        //1.converts string into bytes (msg.getBytes())
        //2. call the write()
        //3. add new line by println()->( write() + flush() ) method
        //4. call flush()
        // ultimately read() and write() comes into action.
    }
}
