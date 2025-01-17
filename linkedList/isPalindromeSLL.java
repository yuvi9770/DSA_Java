package linkedList;

public class isPalindromeSLL {

    public static Node head;
    public static Node tail;
    public static int size;

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


    // check if LL isPalindrome using iteration

    public Node findMid(Node head){
        // Slow-fast Approach
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; // mid point
    }
    public boolean isPalndrome(){
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        Node midNode = findMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;   
        }

        Node right = prev; // right half head
        Node left = head;

        // check left & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    // check if LL isPalindrome using recursion
    public boolean helper(Node right, int height){
        if (right == null) {
            return true;
        }
        boolean rRes = helper(right.next, height+1);
        
        if (height >= (size/2)) {
            if (rRes == false) {
                return false;
    
            }else if (pleft.data != right.data) {
                return false;
    
            }else{
                pleft = pleft.next;
                return true;
            } 
        }

        return rRes;
    }
    Node pleft;
    public boolean isPaliByRec(){
        if (head == null) {
            return true; 
        }

        pleft = head;
        return helper(head, 0);
    }


    public static void main(String[] args) {
        isPalindromeSLL ll = new isPalindromeSLL();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        // ll.addlast(3);
        ll.addlast(2);
        ll.addlast(1);
        ll.print();
        // System.out.println(ll.isPalndrome());

        System.out.println(ll.isPaliByRec());
    }
}