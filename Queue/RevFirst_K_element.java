package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RevFirst_K_element {
    public static void rev(Queue<Integer> Q, int k){
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(Q.poll());
        }
        // System.out.println(s);
        for (int i = 0; i < k; i++) {
            Q.add(s.pop());
        }
        
        int rem = Q.size() - k;
        for (int i = 0; i < rem; i++) {
            Q.add(Q.poll());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        Q.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(Q);

        rev(Q, 3);
        System.out.println(Q);
    }
}