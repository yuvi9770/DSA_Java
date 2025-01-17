package Recursion;

import java.util.ArrayList;

public class printAllSubset_Array {
    public static void printSet(ArrayList<Integer> subsets){
        for (int i = 0; i < subsets.size(); i++) {
            System.out.print(subsets.get(i));
        }
        System.out.println();
    }

    public static void subpart(int n[], ArrayList<Integer> subsets, int idx){
        if (n.length == idx) {
            printSet(subsets);
            return;
        }

        subsets.add(n[idx]);
        subpart(n, subsets, idx+1);
        subsets.remove(subsets.size() - 1);

        subpart(n, subsets, idx+1);
    }

    public static void main(String[] args) {
        int n[] = {3,1,2};
        ArrayList<Integer> subsets = new ArrayList<>();
        subpart(n, subsets,0);
    } 
}
