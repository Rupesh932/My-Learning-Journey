package core.CoreBasic.oopinjava.constructor;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(130, "Bhole ", 59, "Patigairha University");
        Student s2 = new Student(125, "Raju", 47, "Pokhara University");
        Student s3 = new Student(120, "Dhanaraj", 45, "Dharan University");
        Student s4 = new Student(115, "Mohan", 33, "Purbanchaal University");
        Student s5 = new Student(130, "Bhole ", 59, "Patigairha University");

        Student s6 = s2;

        System.out.println();
        System.out.println(" Hashcode: " + s1.hashCode() + " details");
        System.out.println(s1.toString());
        System.out.println();

        System.out.println(" Hashcode: " + s2.hashCode() + " details");
        System.out.println(s2.toString());
        System.out.println();

        System.out.println(" Hashcode: " + s3.hashCode() + " details");
        System.out.println(s3.toString());
        System.out.println();

        System.out.println(" Hashcode: " + s4.hashCode() + " details");
        System.out.println(s4.toString());
        System.out.println();

        System.out.println(" Hashcode: " + s5.hashCode() + " details");
        System.out.println(s5.toString());
        System.out.println();

        System.out.println(s1.equals(s5));// true
        System.out.println(s1 == s5);// false
        System.out.println(s2 == s6);// true
        System.out.println(s2.equals(s6));// true
    }
}

class Student {
    int rollNo;
    String name;
    int age;
    String institute;

    Student(int rollNo, String name, int age, String institute) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "[ Name: " + this.name + ", Age: " + this.age + ", Institute: " + this.institute + ", RollNo: "
                + this.rollNo + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Student st = (Student) o;

        return (st.rollNo == this.rollNo) && (st.age == this.age) && (Objects.equals(st.name, this.name))
                && (Objects.equals(st.institute, this.institute));

    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name, age, institute);
    }
}

    // constructor overload and this chaning
    class Teacher{
        int tid;
        String name;
        String department;
        String majorSubject;
        int salary;
        boolean hasTution;

        Teacher(){

        }
        Teacher(int tid){
            this.tid = tid;
        }
        Teacher(int tid,String name){
            this(tid);
            this.name = name;
        }
        Teacher(int tid,String name,String department){
            this(tid,name);
            this.department = department;
        }
        Teacher(int tid,String name,String department,String majorSubject){
            this(tid,name,department);
            this.majorSubject = majorSubject;
        }

        Teacher(int tid,String name,String department,String majorSubject,int salary){
            this(tid,name,department,majorSubject);
            this.salary = salary;
        }
         
        Teacher(int tid,String name,String department, String majorSubject,int salary,boolean hasTution){
          this(tid,name,department,majorSubject,salary);
            this.hasTution = hasTution;
        }
    }

      class Teacher1{
        int tid;
        String name;
        String department;
        String majorSubject;
        int salary;
        boolean hasTution;

        Teacher1(){//best practice
           this( 0);
        }
        Teacher1(int tid){
            this(tid,"UNKNOWN");
        }
        Teacher1(int tid,String name){
            this(tid,name,"UNKNOWN");
        }
        Teacher1(int tid,String name,String department){
          this(tid,name,department,"UNKNOWN");
        }
        Teacher1(int tid,String name,String department,String majorSubject){
            this(tid,name,department,majorSubject,0);
        }

        Teacher1(int tid,String name,String department,String majorSubject,int salary){
            this(tid,name, department,majorSubject,salary,false);
        }
         
        Teacher1(int tid,String name,String department, String majorSubject,int salary,boolean hasTution){
          this.tid = tid;
          this.name = name;
          this.department = department;
          this.majorSubject = majorSubject;
          this.salary = salary;
          this.hasTution= hasTution;
        }

        

    }
    class Teacher2
    {
        int tid;
        String name;
        String department;
        String majorSubject;
        int salary;
        boolean hasTution;

        Teacher2(){
           this( 0,"UNKNOWN","UNKNOWN","UNKNOWN",0,false);
        }
        Teacher2(int tid){
            this(tid,"UNKNOWN","UNKNOWN","UNKNOWN",0,false);
        }
        Teacher2(int tid,String name){
            this(tid,name,"UNKNOWN","UNKNOWN",0,false);
        }
        Teacher2(int tid,String name,String department){
          this(tid,name,department,"UNKNOWN",0,false);
        }
        Teacher2(int tid,String name,String department,String majorSubject){
            this(tid,name,department,majorSubject,0,false);
        }

        Teacher2(int tid,String name,String department,String majorSubject,int salary){
            this(tid,name, department,majorSubject,salary,false);
        }
         
        Teacher2(int tid,String name,String department, String majorSubject,int salary,boolean hasTution){
          this.tid = tid;
          this.name = name;
          this.department = department;
          this.majorSubject = majorSubject;
          this.salary = salary;
          this.hasTution= hasTution;
        }

        

    }

