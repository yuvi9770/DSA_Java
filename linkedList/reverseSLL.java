package linkedList;

public class reverseSLL {
    public Node head;
    public Node tail;
    public int size;

    // Add data at first
    public void addFirst(int data){
        Node newNode = new Node(data); //create newNode
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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

    // reverse a LL using pointer(next(Node)) using iteration
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
 
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // reverse a LL using data using iteration
    public Node getNodeAt(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void reverseBydata(){
        int li = 0;
        int ri = size-1;

        while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            li++;
            ri--;
        }
    }

    // Display only reverse using recursion
    public void helper(Node head){
        if (head == null) {
            return;
        }
        helper(head.next);
        System.out.print(head.data + " ");
    }
    public void displayRev(){
        if (head == null) {
            return;
        }
        helper(head);
    }

    // reverse a LL using pointer(next(Node)) using recursion
    public void helper2(Node head){
        if (head == null) {
            return;
        }
        helper2(head.next);

        if (head == tail) {
            // do nothing(this cond. is checked only one time)
        }else{
            head.next.next = head;
        }

    }
    public void revRecByPointer(){
        if (head == null) {
            return;
        }
        helper2(head);
        head.next = null;

        Node temp = head;
        head = tail;
        tail = temp;
    }

    // reverse a LL using data using recursion
    public void helper3(Node right, int height){
        if (right == null) {
            return;
        }
        helper3(right.next, height+1);

        if (height >= (size/2)) {
            int temp = right.data;
            right.data = rleft.data;
            rleft.data = temp;

            rleft = rleft.next;
        }

    }
    Node rleft;
    public void revRecByData(){
        if (head == null) {
            return;
        }
        rleft = head;

        helper3(head, 0);
    }


    public static void main(String[] args) {
        reverseSLL ll = new reverseSLL();
        ll.addFirst(7);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();

        // ll.reverse();
        // ll.print();
        // System.out.println(ll.head.data);
        // System.out.println(ll.tail.data);

        // ll.reverseBydata();
        // ll.print();
        // System.out.println(ll.head.data);
        // System.out.println(ll.tail.data);
        // ll.displayRev();

        // ll.revRecByPointer();
        // ll.print();
        // System.out.println(ll.head.data);
        // System.out.println(ll.tail.data);

        ll.revRecByData();
        ll.print();
        System.out.println(ll.head.data);
        System.out.println(ll.tail.data);
    }
}