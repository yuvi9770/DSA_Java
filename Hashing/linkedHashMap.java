package Hashing;

import java.util.LinkedHashMap;

public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Indonesia", 6);
        lhm.put("Nepal", 5);

        // output order is same as insertion
        System.out.println(lhm);
    }
}