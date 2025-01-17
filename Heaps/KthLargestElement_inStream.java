package Heaps;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement_inStream {

    public static List<Integer> getKth(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();

        for (int val : arr) {
            if (pq.size() < k) { // Add in pq
                pq.add(val);

            }else if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }

            if (pq.size() < k) { // find and Add result in List
                res.add(-1);

            } else {
                res.add(pq.peek());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        List<Integer> result= getKth(stream, k);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}