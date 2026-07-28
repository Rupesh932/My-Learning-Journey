package core.CoreAdvance.lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest2 {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();

        list.add(new Student2("hari", 13, 67));
        list.add(new Student2("arun", 32, 56));
        list.add(new Student2("laxmi", 22, 77));
        list.add(new Student2("manoj", 2, 88));
        list.add(new Student2("gyan", 53, 27));


        Collections.sort(list,(s1,s2) -> s1.name.compareTo(s2.name));


        for (Student2 s : list) {
            System.out.println(s.name + ", " + s.rollNo + ", " + s.mark);

        }

    }
}

class Student2 {
    String name;
    int rollNo;
    int mark;

    public Student2(String name, int rollNo, int mark) {
        this.name = name;
        this.rollNo = rollNo;
        this.mark = mark;
    }
}
