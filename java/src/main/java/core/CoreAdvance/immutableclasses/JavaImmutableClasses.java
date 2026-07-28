package core.CoreAdvance.immutableclasses;

public class JavaImmutableClasses {
    public static void main(String[] args) {
        //mutable object
        Mutable ss = new MutableStudent();
        System.out.println("Name: "+ss.getName());
        System.out.println("RollNo: "+ ss.getRollNo());
        //called mutated(override) method
         ss.markAttendance();

         // mutate the field of object
         ss.setName("muji hari");
         ss.setRollNo(-33);

        System.out.println("Name: "+ss.getName());
        System.out.println("RollNo: "+ ss.getRollNo());
        ss.markAttendance();

        //immutable object
        Immutable immutableStudent = new Immutable(101,"hari");
        //no setters to mutate instance field of Immutable object
        System.out.println("Full package: "+ immutableStudent.getClass());
        System.out.println("Name: "+ immutableStudent.getName());
        System.out.println("RollNo: "+ immutableStudent.getRollNo());
        immutableStudent.markAttendance();


    }
}
class Mutable {
    int rollNo;
    String name;
    public Mutable(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }
    public void markAttendance(){
        System.out.println(rollNo+" attendance success");
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public int getRollNo(){
        return this.rollNo;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return  this.name;
    }

}
class MutableStudent extends Mutable {

    MutableStudent(){
        super(101,"hari");
    }
    int count;
    // mutate the behaviour
    @Override
    public void markAttendance(){
        count++;
        System.out.println(this.getClass().toString()+": "+rollNo+" has attendance "+ count+" days ");

    }
}
// make that class immutable
final class Immutable{
    private final int  rollNo;
    private final String name;
    public Immutable(int rollNo,String name){
        this.rollNo = rollNo;
        this.name = name;
    }
   public void markAttendance(){
       System.out.println(rollNo+" attendance success");
   }

    public int getRollNo() {
        return this.rollNo;
    }
    public String getName(){
        return this.name;
    }
}
//class ImmutableStudent extends Immutable{
//  can't inherit from final class.
//}
