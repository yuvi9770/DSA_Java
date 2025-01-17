package Queue;

class queue{
    int arr[];
    int size;
    int rear;

    queue(int n){
        arr = new int[n];
        size = n;
        rear = -1;
    }

    // check Queue isEmpty or not
    public boolean isEmpty(){
        return rear == -1;
    }

    // check Queue isfull or not
    public boolean isfull(){
        return rear == size-1;
    }

    // Add to Queue
    public void add(int data){
        if (isfull()) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    // Remove from Queue
    public int remove(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;

        return front;
    }

    // peek from Queue
    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[0];
    }

    // display Queue
    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        queue Q = new queue(5);
        System.out.println(Q.isEmpty());
        Q.add(5);
        Q.add(3);
        Q.add(9);
        Q.add(4);
        Q.display();

        System.out.println();
        Q.remove();
        Q.display();
    }
}