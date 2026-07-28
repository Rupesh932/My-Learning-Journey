package core.CoreBasic.oopinjava.inheritance;

public class InheritanceTypes {
    //1. single inheritance => A extends B
    //2. multi-level inheritance => A extends B, B extends C, C extends D ...
    //3. hierarchical inheritance => tree like structure, class B and class C extends class A.
    //4. multiple inheritance => not possible at class level

        public static void main(String[] args) {
            //  ComputerEngineeringStudent
            ComputerEngineeringStudent compStudent = new ComputerEngineeringStudent(
                    "Rupesh", 101, "Computer Science", 6, "AI Attendance System"
            );

            System.out.println("--- Computer Student Details ---");
            compStudent.markAttendance();
            compStudent.attendLab();
            compStudent.skills();
            System.out.println(compStudent.toString());
            System.out.println();

            // CivilEngineeringStudents
            CivilEngineeringStudents civilStudent = new CivilEngineeringStudents(
                    "Aayush", 202, "Civil Engineering", 4, "Bridge Load Analysis"
            );

            System.out.println("--- Civil Student Details ---");
            civilStudent.markAttendance();
            civilStudent.attendLab();
            civilStudent.skills();
            System.out.println(civilStudent.toString());
            System.out.println();

            //  Polymorphism (Parent Reference, Child Object)
            // Student s = new Student(...); // Error: Student is abstract
            Student polyStudent = new ComputerEngineeringStudent(
                    "Suman", 303, "Computer Science", 8, "Blockchain Voting"
            );

            System.out.println("--- Polymorphism in Action ---");
            polyStudent.markAttendance();
            polyStudent.attendLab(); // यसले ComputerEngineeringStudent कै Method चलाउँछ
            // polyStudent.Skills(); // Compile Error: Student Reference मा Skills() छैन
            System.out.println(polyStudent.toString());
        }
    }


abstract class Student {
    private String name;
    private int rollNo;
    abstract protected void attendLab();
    Student(String name,int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
 protected void markAttendance(){
     System.out.println(name+" attendance successfully");
 }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
//1.single inheritance
abstract class EngineeringStudent extends Student{
    private String department;
    abstract protected void attendLab();
    EngineeringStudent(String name,int rollNo,String department){
        super(name,rollNo);
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
//2.multi-level inheritance
class ComputerEngineeringStudent extends EngineeringStudent{
    private int semester;
    private String currentProject;

    ComputerEngineeringStudent(String name,int rollNo,String department, int semester,String currentProject){
        super(name,rollNo,department);
        this.semester = semester;
        this.currentProject = currentProject;
    }
    protected void skills(){
        System.out.println("LLD,HLD,Full stack software developer,System Design");
    }
    @Override
    protected void attendLab() {
        System.out.println(getName()+", of "+getDepartment()+" attended computer lab successfully");
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    @Override
    public String toString() {
        return "ComputerEngineeringStudent{" +
                " Name = "+getName()+
                ", RollNo = "+ getRollNo()+
                ", Department = "+ getDepartment()+
                ", currentProject='" + currentProject + '\'' +
                ", semester=" + semester +
                '}';
    }
}
class CivilEngineeringStudents extends EngineeringStudent{
    private int semester;// it should be a property of Student
    private String currentProject;

    CivilEngineeringStudents(String name,int rollNo,String department,int semester,String currentProject){
        super(name,rollNo,department);
        this.semester = semester;
        this.currentProject = currentProject;
    }
    public void skills(){//might be abstract in EngineeringStudent for all child
        System.out.println("all skills that make able to build robust design from tiny to big structure");
    }
    @Override
    protected void attendLab() {
        System.out.println(getName()+", of "+ getDepartment()+" attended civil lab successfully");
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }
    @Override
    public String toString() {
        return "ComputerEngineeringStudent{" +
                " Name = "+getName()+
                ", RollNo = "+ getRollNo()+
                ", Department = "+ getDepartment()+
                ", currentProject='" + currentProject + '\'' +
                ", semester=" + semester +
                '}';
    }
}

//3. hierarchical inheritance
// ScienceStudent and EngineeringStudents extends Student is hierarchical.
// ComputerES and CivilES extends ES is hierarchical.

//4. multiple Inheritance:
// class FullStackEngineeringStudent extends ComputerES, CivilES caused to ambiguous access of skills()
// method present in both parent.
