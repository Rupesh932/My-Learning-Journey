package core.CoreBasic.objectclass;

import java.util.Objects;

public class ObjectClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.name = "rupesh";
        s1.age = 33;

        Student s2 = new Student();
        s2.name = "rupesh";
        s2.age = 33;

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() == s2.hashCode());

        // can't override getClass() because of its final modifier.
        System.out.println(s1.getClass().getName());
        System.out.println(s2.getClass());

        System.out.println(s1 instanceof Student);
        System.out.println(s1 instanceof Object);

        // clone
        Student s3 = (Student) s1.clone();
        System.out.println(s3.name+", "+s3.age);

    }
}

class Student implements Cloneable{
    String name;
    int age;

    @Override
    public String toString() {
        return (name + " " + age);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {// s1.equals(s1)
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Student st = (Student) obj;

        return this.age == st.age && Objects.equals(this.name, st.name);

    }

    @Override
    public int hashCode() {
        // internal hashcode generation : take a prime number(generally it would be 17
        // or 31)

        /*
         * int result = 17;
         * result = result * 31 + age;
         * result = result * 31 +((name == null) ? 0: name.hashCode());
         * return result;
         */
        return Objects.hash(name, age);

    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}