package Queue;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LLqueue{
    Node head = null;
    Node tail = null;

    // check Queue isEmpty or not
    public boolean isEmpty(){
        return head == null; // tail == null
    }

    // Add to Queue
    public void add(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Remove from Queue
    public int remove(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int front = head.data;;
        // single element
        if (head == tail) {
            head = tail = null;

        } else {
            head = head.next;
        }
        return front;
    }

    // peek from Queue
    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }

    // display Queue
    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int SIZE() {
        if (isEmpty()) return 0;

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        LLqueue Q = new LLqueue();
        System.out.println(Q.isEmpty());
        Q.add(5);
        Q.add(3);
        Q.add(9);
        Q.display();

        System.out.println();
        // Q.remove();
        Q.add(77);
        Q.display();

        System.out.println();
        System.out.println(Q.SIZE());
    }
}