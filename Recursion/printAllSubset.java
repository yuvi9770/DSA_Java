package Recursion;

import java.util.ArrayList;

public class printAllSubset {
    public static void printSet(ArrayList<Integer> subsets){
        for (int i = 0; i < subsets.size(); i++) {
            System.out.print(subsets.get(i));
        }
        System.out.println();
    }

    public static void subpart(int n, ArrayList<Integer> subsets){
        if (n == 0) {
            printSet(subsets);
            return;
        }

        subsets.add(n);
        subpart(n-1, subsets);
        subsets.remove(subsets.size() - 1);

        subpart(n-1, subsets);
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subsets = new ArrayList<>();
        subpart(n, subsets);
    }
}