package linkedList;

public class kNodeReverse {
    public Node head;
    public Node tail;
    public int size;

    // get first
    public int getFirst(){
        if (head == null) {
            return -1;
        }
        return head.data;
    }
    
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

    // Add data at last
    public void addlast(int data){
        Node newNode = new Node(data);
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

    // remove data at first
    public int removeFirst(){
        if (size == 0) {
            System.out.println("It is already empty can't remove");
            return -1;

        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // using another LL
    public void kNode(int n){
        if (head == null) {
            return;
        }

        kNodeReverse prev = null;

        while (this.size > 0) {
            kNodeReverse curr = new kNodeReverse();
            
            if (size >= n) {
                for (int i = 0; i < n; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(val);
                }
            } else {
                int s = this.size;
                for (int i = 0; i < s; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addlast(val);
                }
            }

            // Adding element from curr to prev
            if (prev == null) {
                prev = curr;
            }else{
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }
            
        }

        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

    // without using another LL
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;
 
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node getKthNode(Node temp2, int k){
        for (int i = 1; i < k && temp2 != null; i++) {
            temp2 = temp2.next;
        }
        return temp2;
    }

    public Node kReverse(Node head, int k){
        Node temp = head;
        Node prevlast = null;

        while (temp != null) {
            Node kThNode = getKthNode(temp, k);

            if (kThNode == null) {
                if (prevlast != null) {
                    prevlast.next = temp;
                }
                break;
            }

            Node nextNode = kThNode.next;
            kThNode.next = null;

            reverse(temp);

            if (temp == head) {
                head = kThNode;
            }else{
                prevlast.next = kThNode;
            }

            prevlast = temp;
            temp = nextNode;
        }

        return head;
    }
    

    public static void main(String[] args) {
        kNodeReverse ll = new kNodeReverse();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.addlast(7);
        ll.addlast(8);
        ll.addlast(9);
        ll.addlast(10);
        ll.addlast(11);
        ll.print();
        
        // ll.kNode(3);
        // ll.print();
        // System.out.println(ll.head.data);

        ll.head = ll.kReverse(ll.head, 3);
        ll.print();
    }
}