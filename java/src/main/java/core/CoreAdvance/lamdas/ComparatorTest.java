package core.CoreAdvance.lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("hari", 13, 67));
        list.add(new Student("arun", 32, 56));
        list.add(new Student("laxmi", 22, 77));
        list.add(new Student("manoj", 2, 88));
        list.add(new Student("gyan", 53, 27));

        Comparator<Student> sortByName = new SortByName();
        Comparator<Student> sortByRollNo = new SortByRollNo();
        Comparator<Student> sortByMark = new SortByMark();

        Collections.sort(list,sortByMark);

        for(Student s : list){
            System.out.println(s.name +", "+s.rollNo+", "+s.mark);

        }

    }
}

class Student {
     String name;
     int rollNo;
     int mark;

    public Student(String name, int rollNo, int mark) {
        this.name = name;
        this.rollNo = rollNo;
        this.mark = mark;
    }

}

class SortByName implements java.util.Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {

        return s1.name.compareTo(s2.name);
    }
}

class SortByRollNo implements java.util.Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollNo - s2.rollNo;
    }
}

class SortByMark implements java.util.Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.mark - s2.mark;
    }
}

