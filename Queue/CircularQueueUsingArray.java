package Queue;

class CirQueue{
    int arr[];
    int size;
    int front;
    int rear;

    CirQueue(int n){
        arr = new int[n];
        size = n;
        front = -1;
        rear = -1;
    }

    // check Queue isEmpty or not
    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    // check Queue isfull or not
    public boolean isfull(){
        return (rear+1) % size == front;
    }

    // Add to Queue
    public void add(int data){
        if (isfull()) {
            System.out.println("Queue is full");
            return;
        }

        // add 1st element
        if (front == -1) front = 0;

        rear = (rear+1) % size;
        arr[rear] = data;
    }

    // Remove from Queue
    public int remove(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int res = arr[front];
        // delete last element
        if (rear == front) {
            rear = front = -1;

        } else {
            front = (front+1) % size;
        }
        return res;
    }

    // peek from Queue
    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    // display Queue
    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i+1) % size;
        }

        System.out.println();
    }

    public int SIZE() {
        if (isEmpty()) {
            return 0;
        }
        else if (isfull()) {
            return size;
        }
        else if (rear >= front) {
            return rear - front + 1;

        } else {
            return size - front + rear + 1;
        }
    }
}

public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CirQueue Q = new CirQueue(5);
        System.out.println(Q.isEmpty());
        Q.add(5);
        Q.add(3);
        Q.add(9);
        Q.display();

        Q.remove();
        Q.add(77);
        Q.display();

        System.out.println(Q.SIZE());
    }
}