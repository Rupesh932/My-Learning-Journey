package core.CoreAdvance.collectionframework.hierarchy.utility.compareto;

import java.util.*;

public class JavaCompareToConcept {
    public static void main(String[] args) {
        List<StudentWithNoComparable> studentList = new ArrayList<>();
        studentList.add(new StudentWithNoComparable("Mohit",66));
        studentList.add(new StudentWithNoComparable("Rohit",95));
        studentList.add(new StudentWithNoComparable("Aditya",58));

        //compiler does not find the compare logic in SWNC class hence error
       // Collections.sort(studentList);

        //primitives are ok
        List<Integer> integerList = new ArrayList<>();
        integerList.add(111);
        integerList.add(57);
        integerList.add(999);
        integerList.add(23);
        Collections.sort(integerList);
        System.out.println(integerList);

        //compiler finds the compare logic in SWC class hence no error
        List<StudentWithComparable> studentList1 = new ArrayList<>();
        studentList1.add(new StudentWithComparable("Mohit",66));
        studentList1.add(new StudentWithComparable("Rohit",95));
        studentList1.add(new StudentWithComparable("Aditya",58));
        studentList1.add(new StudentWithComparable("Hari",66));
        studentList1.add(new StudentWithComparable("Aanu",66));
        Collections.sort(studentList1);
        for(StudentWithComparable student : studentList1){
            System.out.println(student.name+" ,"+ student.mark);
        }

        //Person test
        personManager();

    }
    public static void personManager(){
        System.out.println("================================");
        Person ram = new Person("Ram","102-004565-df44");
        Person anotherRam = new Person("Ram","105-004765-ef44");
        Person ramCopy = new Person("Ram","102-004565-df44");

        TreeSet<Person> personTree = new TreeSet<>();
        personTree.add(ram);
        personTree.add(anotherRam);

        System.out.println(personTree.size());
        System.out.println(ram.compareTo(anotherRam));
        System.out.println(ram.equals(anotherRam));
        System.out.println(ram.hashCode());
        System.out.println(anotherRam.hashCode());

        System.out.println(ram.compareTo(ramCopy));
        System.out.println(ram.equals(ramCopy));
    }
}





//problem with no comparable
class StudentWithNoComparable{
    String name;
    int mark;

    public StudentWithNoComparable(String name,int mark){
        this.name = name;
        this.mark = mark;
    }
}
//
class StudentWithComparable implements Comparable<StudentWithComparable>{
    String name;
    int mark;

    public StudentWithComparable(String name,int mark){
        this.name = name;
        this.mark = mark;
    }
    @Override
    public int compareTo(StudentWithComparable o) {
        //ascending
       // return this.mark - o.mark;
        //descending
        //return o.mark - this.mark;

        //if marks are same then compare name to follow order
        if(this.mark != o.mark){
            //return this.mark - o.mark;
            return Integer.compare(this.mark,o.mark);
        }
        return this.name.compareTo(o.name);
    }
}

class Person implements Comparable<Person>{
    String name;
    String nid;

    public Person(String name,String nid){
        this.name = name;
        this.nid = nid;

    }
    
    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.name) != 0){
            return this.name.compareTo(o.name);
        }
        return this.nid.compareTo(o.nid);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Person p = (Person)o;
        return this.name.equals(p.name) && this.nid.equals(p.nid);

    }
    @Override
    public int hashCode(){
        return Objects.hash(name,nid);
    }
}
