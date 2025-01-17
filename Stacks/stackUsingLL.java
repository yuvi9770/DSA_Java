package Stacks;

class Node{
    int data;
    Node next;

    public Node(int data){
       this.data = data;
       this.next = null; 
    }
}

class Stack2{
    static Node head = null;

    // isEmpty
    public static boolean isEmpty(){
        return head == null;
    }

    // push
    public static void push(int data){
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // pop
    public static int pop(){
        if (isEmpty()) return -1;

        int top = head.data;
        head = head.next;
        return top;
    }
    // peek
    public static int peek(){
        if (isEmpty()) return -1;

        return head.data;
    }
}

public class stackUsingLL {
    public static void main(String[] args) {
        Stack2.push(52);
        Stack2.push(5);
        Stack2.push(859);

        while (!Stack2.isEmpty()) {
            System.out.println(Stack2.peek());
            Stack2.pop();
        }
    }
}