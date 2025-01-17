package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeUsingJCF {
    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedList<>();
        deq.addFirst(1);
        deq.addFirst(5);
        deq.addFirst(78);
        deq.addFirst(15);
        deq.addLast(8);
        deq.addLast(532);
        System.out.println(deq);

        deq.removeFirst();
        deq.removeLast();
        System.out.println(deq);

        System.out.println(deq.getFirst());
        System.out.println(deq.getLast());
    }
}
