package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    // if end time is not sorted
    public static void select(int start[],int end[]){
        // Sorting
        int activity[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activity[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("MaxActivity: " + maxAct);
        for (Integer i : ans) {
            System.out.print("A" + i + " ");
        }
        System.out.println();
    }


    public static void selection(int start[],int end[]){
        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("MaxActivity: " + maxAct);
        for (Integer i : ans) {
            System.out.print("A" + i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        selection(start, end);

        int start2[] = {0,1,3,5,5,8};
        int end2[] = {6,2,4,7,9,9};
        select(start2, end2);
    }
}