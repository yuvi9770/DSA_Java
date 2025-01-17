package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorQueUsueingJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(7);
        pq.add(1);
        pq.add(8);
        pq.addAll(Arrays.asList(-5,4,978,0));

        while (!pq.isEmpty()) {
            System.out.println(pq.remove()); 
        }
    }
}