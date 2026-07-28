package core.CoreAdvance.collectionframework.hierarchy.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapConstructor {
    //1. empty map
    Map<Integer,String> map1 = new HashMap<>();

    //2. Map with initial capacity
    Map<Integer,String > map2 = new HashMap<>(100);

    //3. capacity and LoadFactor
    Map<Integer,String > map3 = new HashMap<>(100,0.8f);

    //4.another map
    Map<Integer,String > map4 = new HashMap<>(Map.of(101,"Shyam",102,"Bhushan",103,"Rupesh"));

    //5. you can replace HashMap by LinkedHashMap
}
