package core.CoreAdvance.collectionframework.hierarchy.set;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetConstructorAndMethod {
    public static void main(String[] args) {
        //empty constructor
        TreeSet<Integer> treeSet = new TreeSet<>();

        // constructor that takes another collection
        TreeSet<Integer> treeSet1 = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6, 7));

        // methods
        // add
        treeSet.add(80);
        treeSet.add(20);
        treeSet.add(10);
        treeSet.add(90);
        treeSet.add(50);

        //sortedset interface's methods
        System.out.println("smallest in tree set: "+treeSet.first());
        System.out.println("largest in tree set: "+ treeSet.last());
        //BST => most left is smallest; most right is largest
        System.out.println("less then 80(80 not included) in my set: "+ treeSet.headSet(80));
        System.out.println("greater then 20(included 20) in my set: "+ treeSet.tailSet(20));
        System.out.println("subset between 20 to 80 : "+treeSet.subSet(20,80));
        //fromElement - inclusive, toElement = exclusive

        //methods from Navigable Set
        System.out.println("nearest smallest then 80 :"+treeSet.lower(80));
        System.out.println("greatest element less then 80 or equals to 80: "+ treeSet.floor(80));
        System.out.println("smallest but greater then 80: "+treeSet.higher(80));
        System.out.println("smallest or equals to 80 :"+treeSet.ceiling(80));
        System.out.println("pull first from set : " +treeSet.pollFirst());
        System.out.println("pull last from set: "+treeSet.pollLast());
        System.out.println("now we have new first and last element in set");
        System.out.println("First(smallest) : "+ treeSet.first());
        System.out.println("Last(largest): "+treeSet.last());

        treeSet.add(10);
        treeSet.add(90);

        //descending order
        System.out.println("descending order :"+treeSet.descendingSet());
        //iterating
        Iterator<Integer> itr = treeSet.descendingIterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();

        System.out.println("tree set including 80: "+treeSet.headSet(80,true));
        System.out.println("tree set excluding 20: "+treeSet.tailSet(20,false));
        System.out.println("subset between 20(exclusive) to 80(inclusive) : "+treeSet.subSet(20,false,80,true));

    }
}
