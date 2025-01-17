package Heaps;

import java.util.PriorityQueue;;

public class MinOper_HalveArraySum {

    public static int halveArray(int[] nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b, a));
        for (int i : nums) {
            pq.add((double) i);
        }

        int count = 0;
        double temp = sum;
        while (temp > sum/2.0) {
            double curr = pq.remove();
            temp -= curr/2.0;
            pq.add(curr/2.0);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(halveArray(new int[] {5,19,8,1}));

        System.out.println(halveArray(new int[] {3,8,20}));
    }
}