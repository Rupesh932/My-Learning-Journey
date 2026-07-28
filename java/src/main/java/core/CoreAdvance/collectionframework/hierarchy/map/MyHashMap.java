package core.CoreAdvance.collectionframework.hierarchy.map;

public class MyHashMap {

     static class Node<K,V>{
        K key;
        V value;
        int hash;
        Node<K,V> next;
    }
}
