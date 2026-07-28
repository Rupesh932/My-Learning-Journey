package core.CoreAdvance.collectionframework.hierarchy.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapConstructorsAndMethods {

    public static void main(String[] args) {
        //1. empty map
        Map<Integer,String> emptyConsMap = new HashMap<>();

        // adding key and value to map
        emptyConsMap.put(101,"Rohit");
        emptyConsMap.put(102,"Aaman");
        emptyConsMap.put(103,"Mohit");
        emptyConsMap.put(104,"Mohan");
        emptyConsMap.put(105,"Rohan");

        System.out.println("Size of Map: "+emptyConsMap.size());
        System.out.println("Map isEmpty(): "+emptyConsMap.isEmpty());

        //contains: Collection => Map: containsKey():O(1) and containsValue(): O(n)
        System.out.println("map.containsKey(104): "+ emptyConsMap.containsKey(104));
        System.out.println("map.containsValue(Rohit); "+emptyConsMap.containsValue("Rohit"));
        System.out.println("map.get(104): "+emptyConsMap.get(104));// value of 104 key
        System.out.println("map.get(1000): "+emptyConsMap.get(1000));// null

        //interesting put()
        System.out.println(emptyConsMap.put(106,"Abhay"));//null => create new node and return null
        System.out.println(emptyConsMap.put(102,"Manish"));//print aaman, but update with Manish
        System.out.println(emptyConsMap.get(102));//manish

        //remove
        System.out.println(emptyConsMap.remove(105));

        //putAll() -> from another map
        // clear()

        // fetch all keys
        Set<Integer> rollNo = emptyConsMap.keySet();
        System.out.println("All Keys: "+rollNo);
        //fetch all values
        Collection<String> name = emptyConsMap.values();
        System.out.println("All Values: "+ name);

        //all entries in map
        Set<Map.Entry<Integer,String>> entries = emptyConsMap.entrySet();
        System.out.println(entries);

        //get target or take method argument
        System.out.println("getOrDefault(105,deleted): "+emptyConsMap.getOrDefault(105,"Deleted"));

        // put if absent from method argument else no update
        System.out.println("putIfAbsent(105,Rohan): "+emptyConsMap.putIfAbsent(105,"Rohan"));// put Rohan
        System.out.println(entries);
        System.out.println("putIfAbsent(105,Rohan): "+emptyConsMap.putIfAbsent(105,"Sohan"));// no update
        System.out.println(entries);

       //remove
        System.out.println(".remove(key): "+ emptyConsMap.remove(101));
        System.out.println(entries);
        //no match -> no remove
        System.out.println(".remove(key,value): "+emptyConsMap.remove(102,"NoMatched"));//false

        //replace() : only replace if key existed, else no node creation
        System.out.println(".replace(key,value): "+emptyConsMap.replace(101,"Rohit"));//null
        emptyConsMap.putIfAbsent(101,"Lohit");
        System.out.println(entries);
        System.out.println(".replace(key,value): "+emptyConsMap.replace(101,"Rohit"));// old value(Lohit)
        System.out.println(entries);

        //only put salman to 101 if 101 has old value rohit
        System.out.println(".replace(key,oldValue,newValue): "+emptyConsMap.replace(101,"Rohit","Salman"));
        System.out.println(entries);

        //Map.Entry's method
        for(Map.Entry<Integer,String> entry: entries){
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Key: "+ key+" => "+" Values: "+value);
        }


        //immutable Map
        Map<Integer,String> immutableMap = Map.of(101,"Shyam",102,"Bhushan",103,"Rupesh");
        //immutableMap.put(104,"unknown"); RunTimeException: UnsupportedOperationException

    }
}
