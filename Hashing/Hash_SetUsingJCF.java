package Hashing;

import java.util.HashSet;

public class Hash_SetUsingJCF {
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

        System.out.println(set.contains(3));
        System.out.println(set.remove(2));
        System.out.println(set);

        System.out.println(set.size());

        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }
}
