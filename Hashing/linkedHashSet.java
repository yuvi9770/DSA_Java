package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class linkedHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(10);
        System.out.println(set);

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(4);
        lhs.add(1);
        lhs.add(2);
        lhs.add(4);
        lhs.add(1);
        lhs.add(2);
        lhs.add(10);
        System.out.println(lhs);
    }
}