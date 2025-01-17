package Queue;

import java.util.Deque;
import java.util.LinkedList;

class MeQueue{
    Deque<Integer> deq = new LinkedList<>();

    public void push(int data){
        deq.addLast(data);
    }

    public int pop(){
        if (deq.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return deq.removeFirst();
    }

    public int peek(){
        if (deq.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return deq.getFirst();
    }

    public void display(){
        if (deq.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (Integer ele : deq) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}

public class QueueUsingDeque {
    public static void main(String[] args) {
        MeQueue Q = new MeQueue();
        Q.pop();
        Q.push(1);
        Q.push(2);
        Q.push(3);
        Q.display();

        System.out.println(Q.peek());
        Q.pop();
        Q.display();
    }
}
