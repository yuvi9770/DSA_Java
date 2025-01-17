package linkedList;

public class interPtLL {
    // Print LL
    public void print(Node head){
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

    // using size parameter
    public int getsize(Node head){
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public Node interpt(Node headA, Node headB){
        int lenA = getsize(headA);
        int lenB = getsize(headB);

        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }

        }else{
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }


    // without cal len only by iterating
    public Node getInterNode(Node headA, Node headB){
        Node tempA = headA;
        Node tempB = headB;

        while (tempA != tempB) {
            tempA = (tempA != null) ? tempA.next : headB;
            tempB = (tempB != null) ? tempB.next : headA;
        }

        return tempA;
    }


    public static void main(String[] args) {
        interPtLL ll = new interPtLL();

        // list 1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);

        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;

        ll.print(n1);
        ll.print(n2);

        Node res = ll.interpt(n1, n2);

        Node res2 = ll.getInterNode(n1, n2);

        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res2.data);
        }
    }   
}