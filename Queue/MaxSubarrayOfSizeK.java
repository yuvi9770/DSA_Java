package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSubarrayOfSizeK {
    public static int[] subArray(int arr[], int k){
        Deque<Integer> deq = new LinkedList<>();
        int n = arr.length;
        int result[] = new int[n-k+1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && deq.peekFirst() <= i-k) {
                deq.pollFirst();
            }

            while (!deq.isEmpty() && arr[i] > arr[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.addLast(i);

            if (i >= k-1) {
                result[idx++] = arr[deq.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,5,2,3,6};

        int res[] = subArray(arr, 3);
        for (int i : res) {
            System.out.print(i +" ");
        }
    }
}