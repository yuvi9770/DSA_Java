package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(q);

        reverse(q);
        // System.out.println(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}