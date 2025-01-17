package Arraylist;

import java.util.ArrayList;

public class beautiful_Array_usingFormula {
    // using ArrayList
    public static ArrayList<Integer> beautiArr1(int num){
        ArrayList<Integer> result = new ArrayList<>();

        if (num == 1) {
            result.add(1);
            return result;
        }else if (num == 2) {
            result.add(1);
            result.add(2);
            return result;
        }

        ArrayList<Integer> odd = beautiArr1((num+1)/2);
        ArrayList<Integer> even = beautiArr1(num/2);

        for (Integer i : odd) {
            result.add((2*i)-1);
        }
        for (Integer i : even) {
            result.add(2*i);
        }

        return result;  
    }

    // using Array
    public static int[] beautiArr2(int num){
        int res[] = new int[num];

        if (num == 1) {
            return new int[]{1};
        }else if (num == 2) {
            return new int[]{1,2};
        }

        int odd[] = beautiArr2((num+1)/2);
        int even[] = beautiArr2(num/2);

        for (int i = 0; i < odd.length; i++) {
            res[i] = odd[i]*2 - 1;
        }

        for (int j = 0; j < even.length; j++) {
            res[odd.length + j] = even[j]*2;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int res[] = beautiArr2(n);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(beautiArr1(n));

        // convert ArrayList to Array
        ArrayList<Integer> n2 = beautiArr1(n);
        int arr[] = new int[n2.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n2.get(i);  
            System.out.print(arr[i] + " ");
        }
    }
}