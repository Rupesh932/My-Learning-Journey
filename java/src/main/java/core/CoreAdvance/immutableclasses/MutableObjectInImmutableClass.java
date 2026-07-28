package core.CoreAdvance.immutableclasses;

import java.util.Arrays;


public class MutableObjectInImmutableClass {
    public static void main(String[] args) {
        College college = new College("Kathmandu","block-A: building 101t");
        String[] subjects = {"English","Math","Science","Nepali","Computer","Optional"};
        int[] marks = {55,75,66,43,88,66};

        Student student = new Student(101,"Hari","management",college,subjects,marks);
        System.out.println(student.toString());
        System.out.println("*********************************");
        // mutating immutable object student
        student.getCollege().setAddress("USA");
        student.getCollege().setDepartmentId("block-d: building 1024B");
        student.getSubjects()[4] = "hacked";
        student.getMarks()[4] = -99;
        System.out.println(student.toString());


    }
}
//Immutable class(not fully : because of mutable object not using defensive copy
final class Student{
    private final int rollNo;
    private final String name;
    private final String faculty;

    //mutable object inside immutable class.
    private final College college;
    private final  String[] subjects;
    private final int[] marks;

    public Student(int rollNo, String name, String faculty, College college, String[] subjects, int[] marks){
        this.rollNo  = rollNo;
        this.name  = name;
        this.college = college;
        this.faculty = faculty;
        this.subjects = subjects;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public College getCollege() {
        return college;
    }

    public String getFaculty() {
        return faculty;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ",\n name='" + name + '\'' +
                ",\nfaculty='" + faculty + '\'' +
                ",\n college=" + college +
                ",\n subjects=" + Arrays.toString(subjects) +
                ",\n marks=" + Arrays.toString(marks) +
                '}';
    }
}

//mutable
class College{
    private static final String COLLEGE_NAME = "Mr.Thapaliya IT carrier Institute";
    private String address;
    private String departmentId;//like stdin, stdout for OS.(block id)

    public College(String address,String departmentId){
        this.address = address;
        this.departmentId = departmentId;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "College{" +
                "\n College = "+ COLLEGE_NAME +'\''+
                "\naddress='" + address + '\'' +
                ",\n departmentId='" + departmentId + '\'' +
                '}';
    }
}



