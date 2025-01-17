package Queue;

import java.util.Stack;

class MyQueue{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    int peekEle = -1;

    public boolean isEmp(){
        return input.isEmpty() && output.isEmpty();
    }

    public void add(int data){
        if (input.isEmpty()){
            peekEle = data;
        }

        input.push(data);
    }

    // Amortized O(1)
    public int remove(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }
        
        if (output.isEmpty()) {
            // transfer element from input to output
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (output.isEmpty()) {
            return peekEle;
        }
        return output.peek();
    }

    // Display
    public void display(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return;
        }

        // output stack
        for (int i = output.size()-1; i >= 0; i--) {
            System.out.print(output.get(i) + " ");
        }

        // input stack
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
        System.out.println();
    }
}

class TwoStack{ // here i can't utilize the stack properly
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // check if stack is empty
    public boolean isEmp(){
        return s1.isEmpty();
    }

    // Add 
    public void add(int data){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Remove
    public int remove(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.pop();
    }

    // peek
    public int peek(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.peek();
    }

    // Display
    public void display(){
         if (isEmp()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = s1.size()-1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }
        
        System.out.println();
    }
}

public class QueueUsing2_Stack {
    public static void main(String[] args) {
        // TwoStack Q = new TwoStack();
        MyQueue Q = new MyQueue();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.display();

        Q.remove();
        Q.display();

        Q.add(82);
        Q.add(6);
        Q.display();
    }
}