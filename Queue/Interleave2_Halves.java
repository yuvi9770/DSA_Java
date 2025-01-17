package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Interleave2_Halves {
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size/2; i++) {
            firstHalf.add(q.remove());
        }
        
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(q);

        interLeave(q);
        System.out.println(q);
    }
}