package linkedList;

class NodeList{
    int data;
    NodeList next;
    NodeList prev;

    public NodeList(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    } 
}

public class OperationDLL {
    
    public NodeList head;
    public NodeList tail;
    public int size;


    // addFirst
    public void addFirst(int data){
        NodeList newNode = new NodeList(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // addLast
    public void addLast(int data){
        NodeList newNode = new NodeList(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // print
    public void print(){
        NodeList temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // removeFirst
    public int removeFirst(){
        if (head == null) {
            System.out.println("DLL is empty");
            return -1;

        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // removeLast
    public int removeLast(){
        if (head == null) {
            System.out.println("DLL is empty");
            return -1;

        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    // reverse DLL
    public void reverse(){
        NodeList prev = null;
        NodeList curr = head;
        NodeList next;
        NodeList oldhead = head; // Save the old head to set as the new tail

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
        tail = oldhead;
    }

    public static void main(String[] args) {
        OperationDLL dll = new OperationDLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);

        dll.print();

        dll.addLast(10);
        dll.print();

        // System.out.println(dll.size);
        // System.out.println(dll.removeFirst());
        // dll.print();

        dll.removeLast();
        dll.print();

        // dll.reverse();
        // dll.print();

        // System.out.println(dll.head.data);
        // System.out.println(dll.tail.data);
    }
}