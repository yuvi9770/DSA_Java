package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class monotonicAL {
    public static boolean mono(ArrayList<Integer> list){
        int diff = list.get(list.size()-1) - list.get(0);
        boolean res = true;
        
        if (diff < 0) {
            Collections.reverse(list);
        }

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) {
                res = false;
            }
        }
        return res;
    }

    public static boolean monotonic(ArrayList<Integer> list){
        boolean incr = true;
        boolean decr = true;

        for(int i = 0; i < list.size()-1; i++){
            // not of incr case
            if (list.get(i) > list.get(i+1)) {
                incr = false;
            }
            
            // not of decr case
            else if (list.get(i) < list.get(i+1)) {
                decr = false;
            }
        }

        return incr || decr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,2,3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(6,5,4,4));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1,3,2));

        System.out.println(monotonic(arr));
        System.out.println(monotonic(arr2));
        System.out.println(monotonic(arr3));

        System.out.println(mono(arr));
        System.out.println(mono(arr2));
        System.out.println(mono(arr3));
    }
}