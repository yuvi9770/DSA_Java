package Stacks;

import java.util.Stack;

public class stackUsingFrameWork {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(22);
        s.push(56);
        s.push(9);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}