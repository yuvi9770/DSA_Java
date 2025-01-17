package Stacks;

import java.util.ArrayList;

class Stack1{
    static ArrayList<Integer> list = new ArrayList<>();

    // isEmpty
    public static boolean isEmpty(){
        return list.size() == 0;
    }

    // push
    public static void push(int data){
        list.add(data);
    }

    // pop
    public static int pop(){
        if (isEmpty()) return -1;

        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    // peek
    public static int peek(){
        if (isEmpty()) return -1;

        return list.get(list.size() - 1);
    }
}

public class stackUsingArrayList {
    public static void main(String[] args) {
        Stack1.push(5);
        Stack1.push(25);
        Stack1.push(89);

        while (!Stack1.isEmpty()) {
            System.out.println(Stack1.peek());
            Stack1.pop();
        }
    }
}