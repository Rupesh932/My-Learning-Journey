package core.CoreAdvance.collectionframework.hierarchy.set;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class LinkedHashSetConstructor {
    public static void main(String[] args) {
        //1. empty constructor
        Set<Integer> set = new LinkedHashSet<>();// 16 size(load factor 0.75)

        //2. sets initial capacity
        Set<Integer> set1 = new LinkedHashSet<>(100);

        //3. sets initial capacity and load Factor
        Set<Integer> set2 = new LinkedHashSet<>(100, 0.8f);

        //4. constructor that takes another collection
        Set<Integer> set3 = new LinkedHashSet<>(List.of(11,33,44,55,66));
    }

}
