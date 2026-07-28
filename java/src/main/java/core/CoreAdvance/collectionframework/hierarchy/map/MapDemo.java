package core.CoreAdvance.collectionframework.hierarchy.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> rollAndName = new HashMap<>();
        rollAndName.put(101,"Hari");
        rollAndName.put(102,"Man Bahadur");
        rollAndName.put(103,"Ratna Bahadur");
        rollAndName.put(104,"Hari");

        System.out.println(rollAndName);
        System.out.println(rollAndName.get(102));
        System.out.println(rollAndName.containsKey(103));
        System.out.println(rollAndName.containsValue("Narayan"));

    }
}
