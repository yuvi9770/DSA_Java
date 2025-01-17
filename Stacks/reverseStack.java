package Stacks;

import java.util.Stack;

public class reverseStack {
    public static void pushAt(Stack<Integer> s, int data){
        if (s.isEmpty()) {
           s.push(data);
           return;
        }

        int top = s.pop();
        pushAt(s, data);
        
        s.push(top);
    }

    public static void reverse(Stack<Integer> s){
        if (s.isEmpty()) {
            return;
        }
 
        int top = s.pop();
        reverse(s);
        pushAt(s, top);
    }

    public static void printStack(Stack<Integer> st){
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverse(s);
        printStack(s);
    }
}