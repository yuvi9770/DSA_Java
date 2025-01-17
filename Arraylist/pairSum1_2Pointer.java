package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class pairSum1_2Pointer {
    public static boolean sum1(ArrayList<Integer> list, int target){

        int i = 0;
        int j = list.size()-1;

        while(i < j){
            int sum = list.get(i) + list.get(j);
            
            if (sum == target) {
                return true;
            }else if (sum < target) {
                i++;
            }else{ // sum > target
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int target = 5;
        System.out.println(sum1(list, target));
    }
}
