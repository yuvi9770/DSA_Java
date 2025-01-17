package linkedList;

public class removeDuplicateSortedLL {
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

    public void removeDupli(){
        if (head == null) {
            return;
        }
        removeDuplicateSortedLL res = new removeDuplicateSortedLL();
        
        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (res.size == 0 || res.tail.data != val) {
                res.addlast(val);
            }
        }
        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    public void remove(){
        if (head == null) {
            return;
        }
        Node temp = head;
        Node curr = head.next;

        while (curr != null) {
            if (temp.data != curr.data) {
                temp.next = curr;
                temp = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        removeDuplicateSortedLL ll = new removeDuplicateSortedLL();
        ll.addlast(1);
        ll.addlast(1);
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.print();

        // ll.removeDupli();
        // ll.print();

        ll.remove();
        ll.print();
    }
}