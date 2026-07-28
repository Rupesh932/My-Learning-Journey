package core.CoreAdvance.collectionframework.hierarchy.collection;

import java.util.*;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<Integer> alc = new ArrayList<>();
        alc.add(1);alc.add(2);alc.add(3);alc.add(4);alc.add(5);

        // size and empty
        System.out.println("Collection emptiness: "+ alc.isEmpty());
        System.out.println("Collection emptiness: "+ (alc.size() == 0));
        System.out.println("Size of Collection(AL): "+alc.size());

        //boolean contains(Object o) -> checks equals() with list, and return value
        System.out.println("Collection contains Object 4: "+ alc.contains(4));// List O(n), hashing O(1)

        //iterate() -> return Iterator object
        System.out.println("-----------------------------------------------------------------------");

        //Object[] toArray()-> object array(need cast) of any collection(contiguous memory location caused Random Access)
        Collection<Integer> llc = new LinkedList<>(alc);
        llc.add(55);llc.add(66);
        Object[] oarrllc = llc.toArray();
        for(Object o : oarrllc){
            System.out.print(o+" ");

        }
        // T[] toArray(<T>[] a)
        Integer[] iarrllc = llc.toArray(new Integer[0]);
        // new Integer[0] -> only denotes for type(Integer), size not matter)
        for(Integer i : iarrllc){
            System.out.print(+i+" ");
        }

        System.out.println();
        //boolean add(E e)
        Collection<Integer> setc = new HashSet<>(llc);
        System.out.println("Add duplicate element 55 to set DS: "+setc.add(55));

        //boolean remove(Object obj)-> first occurrence from list, removes unique element from hashing
        boolean a1 = alc.add(1);// add duplicate to AL at last
        System.out.println("Add duplicate element 1 to AL DS: "+a1);
        boolean r1 = alc.remove(1);// remove first occurrence (i.e. index 0)
        System.out.println("remove duplicate element's first occurrence 1 from AL DS: "+r1);
        boolean r3 = setc.remove(3);// no duplication no worries
        System.out.println("remove  element 3 from SET DS: "+r3);
        boolean r33 = setc.remove(33);
        System.out.println("try to remove  not existing element 33 from SET DS: "+r33);


    // boolean addAll(Collection<? extends E>c)
    //<? extends E> -> you can add  E type( here Integer) or subtype( subtype of Integer)
     alc.addAll(List.of(77,88,99,1,2,3,4,55));
        System.out.println("------------------------------------------------------------------");
        for(Integer i : alc){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(alc);//override toString() prints alc.

     // boolean containsAll(Collection<?>c) -> needs to check equals()
        System.out.println("alc containsAll(llc): "+alc.containsAll(llc));
        System.out.println("alc containsAll(setc): "+alc.containsAll(setc));
        System.out.println("setc containsAll(llc): "+setc.containsAll(llc));
        System.out.println("setc containsAll(alc): "+setc.containsAll(alc));
        System.out.println("llc containsAll(alc): "+llc.containsAll(alc));
        System.out.println("llc containsAll(setc): "+llc.containsAll(setc));

        //boolean removeAll(Collection<?> c)
            llc.removeAll(List.of(55,66));// removes 55 and 66
        //boolean retainAll(Collection<?> c) -> removes all those are not matching args
         setc.retainAll(List.of(66,55));//keep 55, 66, remaining should remove.
        System.out.println("setc after retainAll(List.of(66,55): "+setc);

        System.out.println("------------------------------------------------------------------");
        //void clear() -> clear any collection
        alc.clear();
        llc.clear();
        setc.clear();
        System.out.println("After alc.clear() call: " +alc);
        System.out.println("After llc.clear() call: " +llc);
        System.out.println("After setc.clear() call: " +setc);
        System.out.println("all collection have been cleared");

        //default method -> functional programming and stream api will covered.

        //object's method
        // equals(), hashCode() -> override.

    }
}
