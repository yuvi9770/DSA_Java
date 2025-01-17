package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class lonelyNum {
    public static ArrayList<Integer> find(ArrayList<Integer> list){
        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer ele : list) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for (Integer num : list) {
            if (map.get(num) > 1 || map.containsKey(num+1) || map.containsKey(num-1)) {
                continue;
            }else{
                res.add(num);
            }
        }

        return res;
    }


    public static ArrayList<Integer> findNum(ArrayList<Integer> list){
        ArrayList<Integer> num = new ArrayList<>();

        Collections.sort(list);

        if (list.size() == 1) {
            num.add(list.get(0));

        }else if (list.size() > 1) {
            if (list.get(0)+1 != list.get(1)) {
                num.add(list.get(0));
            }
            if (list.get(list.size()-2)+1 != list.get(list.size()-1)) {
                num.add(list.get(list.size()-1));
            }
        }

        for (int i = 1; i < list.size()-1; i++) {
            if ((list.get(i-1)+1 != list.get(i)) && (list.get(i)+1 != list.get(i+1))){
                num.add(list.get(i));
            }
        }

        return num;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,5,6,8,1));
        
        ArrayList<Integer> Num = findNum(list);
        System.out.println(Num);

        ArrayList<Integer> Num2 = find(list);
        System.out.println(Num2);
    }
}