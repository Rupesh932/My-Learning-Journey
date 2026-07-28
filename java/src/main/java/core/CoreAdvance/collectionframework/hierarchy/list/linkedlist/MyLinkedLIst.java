package core.CoreAdvance.collectionframework.hierarchy.list.linkedlist;


import core.CoreAdvance.collectionframework.hierarchy.iterator.IteratorInterface;
import core.CoreAdvance.collectionframework.hierarchy.list.ListInterface;

public class MyLinkedLIst<E> implements ListInterface<E> {
    @Override
    public IteratorInterface<E> getIterator() {
        return new LinkedListIterator();
    }
    static class Node<E>{
        E data;
        Node<E> next;
    }
    Node<E> head;

    class LinkedListIterator implements IteratorInterface<E>{

        Node<E> current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
