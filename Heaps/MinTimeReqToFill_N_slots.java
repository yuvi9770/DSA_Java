package Heaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeReqToFill_N_slots {

    public static void MinTimeUsingSort(int arr[], int n, int k){
        // time : O(k logk) and space : O(1)

        Arrays.sort(arr);
        int maxGap = 0;

        for (int i = 1; i < k; i++) {
            maxGap = Math.max(maxGap, arr[i] - arr[i-1]); // by dividing this by 2 we are cal the actual req. time
        }

        int maxTime = Math.max(maxGap/2, Math.max(arr[0] -1, n - arr[k -1]));
        
        System.out.println(maxTime);
    }

    public static void MinTime(int arr[], int n, int k){
        // time : O(n) and space : O(n)
 
        Queue<Integer> q  = new LinkedList<>();
        boolean vis[] = new boolean[n+1];
        int time = 0;

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }

        while (q.size() > 0) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if ((curr- 1 >= 1) && (!vis[curr-1])) {
                    vis[curr-1] = true;
                    q.add(curr-1);
                }

                if ((curr+ 1 <= n) && (!vis[curr+1])) {
                    vis[curr+1] = true;
                    q.add(curr+1);
                }
            }
            time++;
        }

        System.out.println(time - 1);
    }
    public static void main(String[] args) {
        MinTime(new int[] {2,6},11, 2);

        MinTimeUsingSort(new int[] {2,6}, 11, 2);
    }
}