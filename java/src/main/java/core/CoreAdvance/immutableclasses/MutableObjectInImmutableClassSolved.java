package core.CoreAdvance.immutableclasses;

import java.util.Arrays;


public class MutableObjectInImmutableClassSolved {
    public static void main(String[] args) {
        College1 college = new College1("Kathmandu","block-A: building 101t");
        String[] subjects = {"English","Math","Science","Nepali","Computer","Optional"};
        int[] marks = {55,75,66,43,88,66};

        Student1 hari = new Student1(101,"Hari","management",college,subjects,marks);
        System.out.println(hari.toString());
        System.out.println("*********************************");

        // mutating immutable object hari(via mutable object) is failed.
        hari.getCollege().setAddress("USA");
        hari.getCollege().setDepartmentId("block-d: building 1024B");
        hari.getSubjects()[4] = "hacked";
        hari.getMarks()[4] = -99;
        System.out.println(hari.toString());

        System.out.println("*********************************");
        //see copied object
        College1 hariCopy1 = hari.getCollege();
        hariCopy1.setAddress("YOUR HOME");
        hariCopy1.setDepartmentId("block-d:building 255C");
        System.out.println("HARI-COPY  1: "+hariCopy1.toString());
        System.out.println("*********************************");
        System.out.println("AGAIN ORIGINAL HARI's COLLEGE: "+ hari.getCollege().toString());


    }
}
//Immutable class : useing defensive copy
final class Student1 {
    private final int rollNo;
    private final String name;
    private final String faculty;

    //mutable object inside immutable class.
    private final College1 college;
    private final  String[] subjects;
    private final int[] marks;

    public Student1(int rollNo, String name, String faculty, College1 college, String[] subjects, int[] marks){
        this.rollNo  = rollNo;
        this.name  = name;
        this.college = (college == null) ? null: new College1(college.getAddress(),college.getDepartmentId());
        this.faculty = faculty;
        this.subjects = (subjects == null) ? null : subjects.clone();
        this.marks = ( marks == null) ? null : marks.clone();
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public College1 getCollege() {

        return (college == null) ? null : new College1(college.getAddress(),college.getDepartmentId());
    }

    public String getFaculty() {
        return faculty;
    }

    public String[] getSubjects() {

        return (subjects  == null) ? null : subjects.clone();
    }

    public int[] getMarks() {

        return (marks == null) ? null : marks.clone();
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
class College1 {
    private static final String COLLEGE_NAME = "Mr.Thapaliya IT carrier Institute";
    private String address;
    private String departmentId;//like stdin, stdout for OS.(block id)

    public College1(String address, String departmentId){
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



