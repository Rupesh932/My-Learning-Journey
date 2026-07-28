package core.CoreAdvance.collectionframework.hierarchy.list.arraylist;

import core.CoreAdvance.collectionframework.hierarchy.iterator.IteratorInterface;
import core.CoreAdvance.collectionframework.hierarchy.list.ListInterface;

public class MyArrayList<E> implements ListInterface<E> {
    private E[] arr;
    private int size;
    @Override
    public IteratorInterface<E>  getIterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements IteratorInterface<E>{
        int pos = 0;
        @Override
        public boolean hasNext(){
            return (pos < size);
        }

        @Override
        public  E next(){
            return arr[pos++];
        }
    }
}
