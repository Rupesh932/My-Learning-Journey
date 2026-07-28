package core.CoreAdvance.collectionframework.hierarchy.iterable;

import core.CoreAdvance.collectionframework.hierarchy.iterator.IteratorInterface;



public interface IterableInterface<E> {
   IteratorInterface<E> getIterator();
}
