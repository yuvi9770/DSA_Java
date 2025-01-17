package linkedList;

public class ZigZagSLL {
    public Node head;
    public Node tail;
    public int size;

    // Add data at first
    public void addFirst(int data){
        Node newNode = new Node(data);
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
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // zigzag using iterative approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void merge(Node left, Node right){
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public void zigzag(){
        if (head == null || head.next == null) {
            return;
        }

        // find mid
        Node mid = findMid(head);

        // reverse 2nd half
        Node secondHalf = reverse(mid.next);
        mid.next = null;

        // zig-zag merge
        merge(head, secondHalf);
    }


    // zigzag using recursive approach
    public void helper(Node right, int height){
        if (right == null) {
            return;
        }
        helper(right.next, height+1);

        if (height > (size/2)) {
            Node temp = fleft.next;
            fleft.next =  right;
            right.next = temp;
            fleft = temp;
            
        }else if (height == (size/2)) {
            tail = right;
            tail.next = null;
        }

    }
    Node fleft;
    public void zigzagRec(){
        if (head == null || head.next == null) {
            return;
        }
        fleft = head;
        helper(head, 0);
    }


    public static void main(String[] args) {
        ZigZagSLL ll = new ZigZagSLL();
        // ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();

        // ll.zigzag();
        // ll.print();

        ll.zigzagRec();
        ll.print();
    }
}