package Hashing;

import java.util.HashMap;

public class Hash_MapUsingJCF {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Get - O(1)
        int pop = hm.get("India");
        System.out.println(pop);

        System.out.println(hm.get("America"));

        // containsKey - O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("America"));

        // Remove - O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        System.out.println(hm.remove("America"));
        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // isEmpty
        System.out.println(hm.isEmpty());

        hm.clear(); // remove everyThing for HashMap
        System.out.println(hm.isEmpty());
    }
}