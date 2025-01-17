package Arraylist;

import java.util.ArrayList;

public class beautiful_Array {
    public static ArrayList<Integer> Arr(ArrayList<Integer> num){
        if (num.size() <= 2) {
            return num;
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < num.size(); i += 2) {
            left.add(num.get(i));
        }
        for (int i = 1; i < num.size(); i += 2) {
            right.add(num.get(i));
        }

        ArrayList<Integer> res = Arr(left);
        res.addAll(Arr(right));
        return res;
    }

    public static ArrayList<Integer> beautiArr(int n){
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        return Arr(num);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(beautiArr(n));
    }
}