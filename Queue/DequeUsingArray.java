package Queue;

class MyDeque{
    int arr[];
    int front;
    int rear;
    int size;

    public MyDeque(int n) {
        arr = new int[n];
        front = -1;
        rear = -1;
        size = n;
    }

    // check isfull or not
    public boolean isfull(){
        return ((front == 0 && rear == size-1) || front == rear+1);
    }

    // check isEmpty or not
    public boolean isEmpty(){
        return front == -1;
    }

    // Insert at Front
    public void addFirst(int data){
        if (isfull()) {
            System.out.println("OverFlow");
            return;
        }

        // Queue initial empty
        if (front == -1) front = rear = 0;

        // front at first pos
        else if (front == 0) front = size-1;

        // decrease front by 1
        else front = front-1;

        arr[front] = data;

    }
    
    // Insert at Rear
    public void addLast(int data){
        if (isfull()) {
            System.out.println("OverFlow");
            return;
        }

        // Queue initial empty
        if (front == -1) front = rear = 0;

        // rear at last pos
        else if (rear == size-1) rear = 0;

        // increase rear by 1
        else rear = rear+1;

        arr[rear] = data;
    }

    // Delete at Front
    public int removeFirst(){
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        int val = arr[front];

        // check if only one element
        if (front == rear) front = rear = -1;

        // front at last pos
        else if (front == size-1) front = 0;

        // increse front by 1
        else front = front+1;

        return val;
    }

    // Delete at rear
    public int removeLast(){
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        int val = arr[rear];

        // check if only one element
        if (front == rear) front = rear = -1;

        // front at last pos
        else if (rear == 0) rear = size-1;

        // increse front by 1
        else rear = rear-1;

        return val;
    }

    // get front
    public int getFirst(){
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        return arr[front];
    }

    // get Rear
    public int getLast(){
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow");
            return -1;
        }

        return arr[rear];
    }

    // display
    public void display(){
        System.out.println("front: " + front + ", rear: " + rear);
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i+1) % size;
        }
        System.out.println();
    }
}

public class DequeUsingArray {
    public static void main(String[] args) {
        MyDeque deq = new MyDeque(8);
        deq.addFirst(5);
        deq.addFirst(9);
        deq.addFirst(2);
        deq.addLast(21);
        deq.addLast(91);
        deq.display();

        System.out.println(deq.getFirst());
        System.out.println(deq.getLast());

        deq.removeFirst();
        deq.removeLast();
        deq.display();
    }
}