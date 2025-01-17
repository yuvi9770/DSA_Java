package Arraylist;

import java.util.ArrayList;

public class beautiful_Array_divide_conquer {
    public static void Arr(int start, int increment,ArrayList<Integer> num,int n){
        if (start > n) {
            return;
        }else if(start + increment > n){
            num.add(start);
            return;
        }

        Arr(start, 2 * increment, num, n);
        Arr(start + increment, 2 * increment, num, n);

    }

    public static ArrayList<Integer> beautiArr(int n){
        ArrayList<Integer> num = new ArrayList<>();
        Arr(1, 1, num, n);
        return num;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(beautiArr(n));
    }
}
