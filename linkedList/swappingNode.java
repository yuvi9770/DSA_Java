package linkedList;

public class swappingNode {
    public Node head;
    public Node tail;
    public int size;

    // Add data at last
    public void addlast(int data){
        Node newNode = new Node(data); //create newNode
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print LL
    public void print(){
        if (head == null) {
            System.out.println("LL is empty can't print");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void swap(int x, int y){
        if (x == y) return;

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        
        if (currX == null || currY == null) return;

        if (prevX != null){
            prevX.next = currY;

        } else{
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;

        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;

        swappingNode ll = new swappingNode();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.print();

        ll.swap(x, y);
        ll.print();
    }
}