package linkedList;

public class removeNthNodeFromEnd {
    public Node head;
    public Node tail;

    // Add data at first
    public void addFirst(int data){
        Node newNode = new Node(data); //create newNode
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

    // delete data at Nth from End
    public void deleteNthfromEnd(int n){
        // calculate size of ll
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (sz == 0) {
            return;
        }
        if (sz == n) {
            head = head.next; // remove First
            return;
        }
        if (n <= 0) {
            return;
        }

        // size - n
        int i = 1;
        int endPt = sz-n;

        if (endPt < 0) {
            return;
        }
    
        Node prev = head;
        while (i < endPt) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // delete data at Nth from End using two pointer
    public void deleteNth(int n){
        if (n <= 0) {
            return;
        }

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) { // handle the case where n is greater then size of ll
                return;
            }
            fast = fast.next;
        }

        if (fast == null) { // handle the case where n equal to size of ll
            head = head.next;
            return;
        }

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return;
    }

    public static void main(String[] args) {
        removeNthNodeFromEnd ll = new removeNthNodeFromEnd();
        ll.addFirst(7);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();

        // ll.deleteNthfromEnd(1);
        // ll.print();

        ll.deleteNth(1);
        ll.print();
    }
}