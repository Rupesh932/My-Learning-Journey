package core.CoreAdvance.javastandardIO;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BufferedReader
public class ReaderInJava {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);//System.in: object of InputStream(byte stream)
        //isr : converts bytes into char.
        BufferedReader br = new BufferedReader(isr);//stores char into own buffer(char array of 8kb default)
        //one liner
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = "Enter your name: ";
        System.out.write(msg.getBytes());
        System.out.flush();

        String name = br.readLine();//os-buffer -> own buffer(through isr) => input
        String fullMsg = "You Entered: " + name;
        System.out.write(fullMsg.getBytes());// stdout from own buffer(output stream buffer) -> os buffer -> display(screen) => output
        System.out.flush();// force to flush to os buffer even output buffer is not fully filled -> display

        //problems 1. reads only String
        String intMsg = "\nEnter your number: ";
        System.out.write(intMsg.getBytes());
        System.out.flush();
        int x = Integer.parseInt(br.readLine());
        String intFulMsg = "You entered :" + x;
        System.out.write(intFulMsg.getBytes());
        System.out.flush();

    }
}
