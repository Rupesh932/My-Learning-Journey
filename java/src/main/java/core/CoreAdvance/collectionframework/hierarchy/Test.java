package core.CoreAdvance.collectionframework.hierarchy;

import core.CoreAdvance.collectionframework.hierarchy.list.arraylist.MyArrayList;
import core.CoreAdvance.collectionframework.hierarchy.iterator.IteratorInterface;
import core.CoreAdvance.collectionframework.hierarchy.list.ListInterface;

public class Test {
    public static void main(String[] args) {
        ListInterface<Integer> list = new MyArrayList<>();
        IteratorInterface<Integer> itr = list.getIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
