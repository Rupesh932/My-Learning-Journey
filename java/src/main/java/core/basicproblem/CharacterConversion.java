package core.basicproblem;

public class CharacterConversion {
    public static char toUpper(char ch){

        if(ch >= 'a' && ch <= 'z'){
            return (char)(ch-32);
        }
        return ch;
    }
    public static void main(String[] args) {
        System.out.println(toUpper('b'));
    }
}
