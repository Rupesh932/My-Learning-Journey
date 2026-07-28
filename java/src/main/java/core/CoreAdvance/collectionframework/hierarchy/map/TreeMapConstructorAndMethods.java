package core.CoreAdvance.collectionframework.hierarchy.map;

import java.util.TreeMap;

public class TreeMapConstructorAndMethods {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(101,"Shyam");
        treeMap.put(102,"Ram");
        treeMap.put(103,"Bhushan");
        treeMap.put(104,"Rupesh");
        treeMap.put(105,"Samjhana");
        treeMap.put(106,"Balaram");
        System.out.println(treeMap);

        //we've almost same method to TreeSet, only need to be care is key and value
        System.out.println("treeMap().firstKey(): "+ treeMap.firstKey());
        System.out.println("treeMap().lastKey(): "+ treeMap.lastKey());

        System.out.println("treeMap().firstEntry(): "+treeMap.firstEntry());
        System.out.println("treeMap().lastEntry(): "+treeMap.lastEntry());

        System.out.println("treeMap().headMap(): "+ treeMap.headMap(103));//toKey exclusive
        System.out.println("treeMap().tailMap(): "+ treeMap.tailMap(103));//formKey inclusive

        System.out.println("treeMap().lowerKey(): "+ treeMap.lowerKey(103));
        System.out.println("treeMap().lowerEntry(): "+ treeMap.lowerEntry(103));

        System.out.println("treeMap().descendingMap(): "+ treeMap.descendingMap());
    }
}
