package core.CoreAdvance.collectionframework.hierarchy.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> nameSet = new HashSet<>();
        nameSet.add("Hari");
        nameSet.add("Rupesh");
        nameSet.add("Tuladhar");
        nameSet.add("Bishnu");
        nameSet.add("Rupesh");

        System.out.println("nameSet.contains(Hari): "+ nameSet.contains("Hari"));

    }
}
