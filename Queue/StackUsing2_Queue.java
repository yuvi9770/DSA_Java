package Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack{ // using single Queue
    Queue<Integer> que = new LinkedList<>();

    public boolean isEmp(){
        return que.isEmpty();
    }

    public void push(int data){
        que.offer(data);
        int n = que.size();
        for (int i = 0; i < n-1; i++) {
            que.offer(que.poll());
        }
    }

    public int pop(){
        return que.poll();
    }

    public int peek(){
        return que.peek();
    }

    public void display(){
        if (isEmp()) return;

        System.out.println(que);
    }
}

class Optimize_TwoQueue{ // push - O(n)
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public boolean isEmp(){
        return q1.isEmpty();
    }

    public void swap(){
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public void push(int data){
        q2.offer(data); // add -> offer
        while (!q1.isEmpty()) {
            q2.offer(q1.poll()); // poll -> remove
        }
        swap();
    }

    public int pop(){
        return q1.poll();
    }

    public int peek(){
        return q1.peek();
    }

    public void display(){
        if (isEmp()) return;

        System.out.println(q1);
    }
}

class TwoQueue{ // pop and peek - O(n)
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // check is Empty
    public boolean isEmp(){
        return q1.isEmpty() && q2.isEmpty();
    }

    // Add
    public void push(int data){
        if (!q1.isEmpty()) {
            q1.add(data);

        } else {
            q2.add(data);
        }
    }

    // helper method for pop and peek
    public int helper(){
        Queue<Integer> nonEmpty  = q1.isEmpty() ? q2 : q1;
        Queue<Integer> Empty  = q1.isEmpty() ? q1 : q2;
        int top = -1;

        while (!nonEmpty.isEmpty()) {
            top = nonEmpty.remove();
            if (nonEmpty.isEmpty()) break;

            Empty.add(top);
        }

        return top;
    }
    
    // Remove
    public int pop(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return helper();
    }

    // peek
    public int peek(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int top = helper();
        push(top);

        return top;
    }

    // Display
    public void display(){
        if (isEmp()) {
            System.out.println("Queue is empty");
            return;
        }
        // while (!Q.isEmp()) {
        //     System.out.print(Q.pop() + " ");
        // }
        System.out.println(!q1.isEmpty() ? q1 : q2);
    }
}

public class StackUsing2_Queue {
    public static void main(String[] args) {
        // TwoQueue Q = new TwoQueue();
        // Optimize_TwoQueue Q = new Optimize_TwoQueue();
        MyStack Q = new MyStack();
        Q.push(5);
        Q.push(65);
        Q.push(54);
        Q.display();

        Q.pop();
        Q.display();
    }
}