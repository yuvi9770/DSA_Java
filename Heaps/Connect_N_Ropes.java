package Heaps;

import java.util.PriorityQueue;

public class Connect_N_Ropes {

    public static void minCost(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = ropes.length;

        for (int i = 0; i < n; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.poll();
            int min2 = pq.poll();
            int sum = min + min2;

            cost += sum;
            pq.add(sum);            
        }

        System.out.println("Minimum cost is : " + cost);
    }

    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};
        minCost(ropes);
    }
}