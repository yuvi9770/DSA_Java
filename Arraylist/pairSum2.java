package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class pairSum2 {
    public static boolean sum2(ArrayList<Integer> list, int target){

        int n = list.size();

        int lp = -1; // smallest number
        int rp = -1; // largest number

        for (int i = 0; i < n; i++) {
            // breaking point
            if (list.get(i) > list.get(i+1)) { 
                lp = i+1;
                rp = i;
                break;
            }
        }

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);

            if (sum == target) {
                return true;
            }else if (sum < target) {
                lp = (lp+1) % n;
            }else{
                rp = (n + rp - 1) % n;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11,15,6,8,9,10));
        int target = 16;
        System.out.println(sum2(list, target));
    }
} 