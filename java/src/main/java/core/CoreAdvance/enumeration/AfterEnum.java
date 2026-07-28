package core.CoreAdvance.enumeration;

public class AfterEnum {
    public static void main(String[] args) {
        // type safety(status can have three value only : compiler knows)
        EnumPaymentStatus status = EnumPaymentStatus.SUCCESS;;
        System.out.println("SUCCESS CONSTANT: "+status.name());


    }
}
//Enum => Enumerations(Enumerated type)
// 1. pre-defined set of constant
// 2. special type of class
// 3. if class, it has all capabilities which a class could have instead extends another class(already Enum extended)
// 4. states, behavior,constructor,
enum Direction{
    NORTH,
    SOUTH,
    EAST,
    WEST;
}

enum EnumPaymentStatus {
    SUCCESS,
    FAILED,
    PENDING;
}
enum DayOfWeek{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}
