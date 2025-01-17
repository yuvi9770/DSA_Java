package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class IterateOnHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(4);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(10);
        set.add(null);

        System.out.println(set); 

        // using Iterator
        Iterator<Integer> i = set.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

        // using Advance loop
        for (Integer j : set) {
            System.out.print(j + " ");
        }
    }
}