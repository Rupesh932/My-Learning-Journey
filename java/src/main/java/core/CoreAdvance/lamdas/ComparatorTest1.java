package core.CoreAdvance.lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest1 {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();

        list.add(new Student1("hari", 13, 67));
        list.add(new Student1("arun", 32, 56));
        list.add(new Student1("laxmi", 22, 77));
        list.add(new Student1("manoj", 2, 88));
        list.add(new Student1("gyan", 53, 27));


        Collections.sort(list, new Comparator<Student1>() {
            @Override
            public int compare(Student1 s1, Student1 s2) {
                //return s1.name.compareTo(s2.name);
                //return s1.mark - s2.mark;
                return s1.rollNo - s2.rollNo;
            }
        });


        for (Student1 s : list) {
            System.out.println(s.name + ", " + s.rollNo + ", " + s.mark);

        }

    }
}

class Student1 {
    String name;
    int rollNo;
    int mark;

    public Student1(String name, int rollNo, int mark) {
        this.name = name;
        this.rollNo = rollNo;
        this.mark = mark;
    }

}





