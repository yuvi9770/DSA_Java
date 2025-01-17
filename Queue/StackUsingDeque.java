package Queue;

import java.util.Deque;
import java.util.LinkedList;

class MeStack{
    Deque<Integer> deq = new LinkedList<>();

    public void push(int data){
        deq.addLast(data);
    }

    public int pop(){
        if (deq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return deq.removeLast();
    }

    public int peek(){
        if (deq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return deq.getLast();
    }

    public void display(){
        if (deq.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (Integer ele : deq) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}

public class StackUsingDeque {
    public static void main(String[] args) {
        MeStack s = new MeStack();
        s.pop();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();

        System.out.println(s.peek());
        s.pop();
        s.display();
    }
}