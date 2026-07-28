package core.CoreAdvance.enumeration;

// beyond java 1.5
public class BeforeEnum {
    public static void main(String[] args) {
        int status = PaymentStatus.SUCCESS;
        System.out.println( "SUCCESS CODE: "+status);

        //problems
        //1. can be changed(bugs in run time, even compile time can't catch : type safety(we can assign random integer value)
        status = 100;
        System.out.println( "SUCCESS CODE: "+status);
        //2. not readable
        if(status == 1){
            // what is 1 actually representing ?
        }
        //3. no logically grouping
        if(status == Role.ADMIN){
            // status : PaymentStatus, misleading
        }
        //let those constant fields make string
        // again we need to perform case matching, compare(letter by letter makes slow),null management
        // those are heavy task to perform tiny task

    }
}
//payment status => SUCCESS, FAILED, PENDING -> constant i.e. final
class PaymentStatus {
    public static final int SUCCESS = 1;
    public static final int FAILED = 2;
    public static final int PENDING  = 3;

}
// Role => USER, ADMIN,GUEST
class Role {
    public static final int USER = 1;
    public static final int ADMIN = 2;
    public static final int GUEST  = 3;
    //problem 4. allowed duplicate value, no compiler error same for String
    public static final int MANAGER = 2;

}


