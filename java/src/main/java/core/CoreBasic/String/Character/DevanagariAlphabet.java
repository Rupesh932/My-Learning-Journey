package core.CoreBasic.String.Character;

public class DevanagariAlphabet {
    public static void main(String[] args) {
        String gyaFromUnicodeHex = "\u091C\u094D\u091E";
        String traUnicodeHex = "\u0924\u094D\u0930";

        //2325 (क) + 2381 (हलन्त) + 2359 (ष)
        char ka = (char)2325;
        char halanta = (char)2381;
        char sha = (char)2359;
        String kshyaUnicodeDecimal = ""+ ka+halanta+sha;

        for(int i = 2305;i<=2361;i++){
            System.out.print((char)i+" ");
        }
        System.out.print(kshyaUnicodeDecimal+" "+traUnicodeHex+" "+gyaFromUnicodeHex);
    }
}

