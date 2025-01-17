package Hashing;

import java.util.HashMap;
import java.util.Set;

public class IterateOnHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String ke : keys) {
            System.out.println("key = " + ke + ", value = " + hm.get(ke));
            
        }   

        System.out.println(hm.entrySet());
    }
}