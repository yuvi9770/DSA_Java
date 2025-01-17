package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingJCF {
    public static void print(Queue<Integer> Q){
        for (Integer ele : Q) {
            System.out.print(ele + " ");
        }
        // while (!Q.isEmpty()) {
        //     System.out.println(Q.remove());
        // }
    }
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>(); // ArrayDeque
        System.out.println(Q.isEmpty());
        Q.add(5);
        Q.add(3);
        Q.add(9);
        print(Q);

        System.out.println();
        Q.remove();
        Q.add(59);
        print(Q);
    }
}