package Hashing;

import java.util.TreeSet;

public class treeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Nodia");
        ts.add("Bengaluru");
        ts.add("Delhi");
        ts.add("Mumbai");

        System.out.println(ts);
    }
}
