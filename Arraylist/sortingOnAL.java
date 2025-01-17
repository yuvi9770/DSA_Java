package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sortingOnAL {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,5,9,6,8));
        list.add(0);

        System.out.println(list);

        // ascending order
        Collections.sort(list);
        System.out.println(list);

        // descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}