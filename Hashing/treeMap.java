package Hashing;

import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> thm = new TreeMap<>();
        thm.put("India", 100);
        thm.put("China", 150);
        thm.put("US", 50);
        thm.put("Indonesia", 6);
        thm.put("Nepal", 5);

        // sort on the basis of key
        System.out.println(thm);
    }
}
