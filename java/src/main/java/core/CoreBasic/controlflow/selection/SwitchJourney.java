package core.CoreBasic.controlflow.selection;

public class SwitchJourney {
    public static void main(String[] args) {
        System.out.println(java1To13Switch(500));
        System.out.println(java14Switch());
        System.out.println(java21Switch());
    }

    public static String java1To13Switch(int day) {
        // java 1 - 7 (byte,short int, char,and enum only)
        //java 7-13(String)
        //forgatting break leads to fall-through
        // switch was statement and default is optional
        
        if(day < 1){
            return "Day should not be negative";
        }
        if(day > Integer.MAX_VALUE){
            return "Too long value to calculate day,please try small or exact day";
        }
        String result = " ";
        switch (day % 7) {
            case 1:
                result = "SUNDAY";
                break;
            case 2:
                result = "MONDAY";
                break;
            case 3:
                result = "TUESDAY";
                break;
            case 4:
                result = "WEDNESDAY";
                break;
            case 5:
                result = "THRUSDAY";
                break;
            case 6:
                result = "FRIDAY";
                break;
            case 7:
                result = "SATURDAY";
                break;

        }

        //use case of fall-through
        int random = (int)(Math.random() * 12) +1;
        int days;
        switch (random) {
            case 1:case 3: case 5: case 7: case 8: case 10: case 12:
                days  = 31;
                break;
            case 4:case 6: case 9: case 11:
               days = 30;
                break;
            case 2:
                days = 28;
                break;
           default:days = -1;

        }
        System.out.println("month "+random + " has "+days+" days");

        return result;
    }

    public static String java14Switch(){
        // now switch is a expression and switch expression must have default case but no need of break
         int random = (int)(Math.random() * 12) +1;
        int days = switch(random){
                case 1,3,5,7,8,10,12 -> 31;
                case 4,6,9,11 -> 30;
                case 2 ->{
                    System.out.println("Feburary)");
                    yield 28;
                }
                 default -> {
                    System.out.println("invalid random but now this is never reached");
                    yield -1;
                }
        };
        return "month "+random + "has "+days+" days";
    }

    public static String java21Switch(){
        //old school
        Object obj = "hello";
        if(obj instanceof String ){
            String s = (String) obj;
            System.out.println(s.length());
        }
        if(obj instanceof Integer i){
            System.out.println(i*i);
        }

        //new school(java 21)
        switch(obj){
            case Integer i -> System.out.println("its integer object");
            case String  s -> System.out.println("its String object");
            case null  -> System.out.println("its null)");
             default -> System.out.println("other type");
        }

        //when keyword

         String result = switch(obj){
            case Integer i when i > 1000-> "it big integer";
            case Integer i when i > 0 -> "its small integer" ;
            case Integer i when i < 0 -> " its negative integer";
            case String  s when s.isEmpty()-> "its empyt String";
            case String s when (s != null) -> "character at first index is "+s.charAt(0);
             default -> "nither Integer nor String encountered ";
        };
        return result;
    }
}
