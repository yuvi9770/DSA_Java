package Heaps;

import java.util.PriorityQueue;

class pair{
    int val, idx;

    public pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class SlidingWindowMaximum {
    public static int[] maxNum(int arr[], int k){
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b) -> b.val - a.val);
        int n = arr.length;
        int res[] = new int[n-k+1];

        // first window
        for (int i = 0; i < k; i++) {
            pq.add(new pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,5,2,3,6};
        int k = 3;

        int result[] = maxNum(arr, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}