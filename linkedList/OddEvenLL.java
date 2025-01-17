package linkedList;

public class OddEvenLL {
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

    // modify data into two separate LL
    public void oddEven(){
        if (head == null) {
            return;
        }
        OddEvenLL odd =new OddEvenLL();
        OddEvenLL even =new OddEvenLL();

        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (val % 2 == 0) {
                even.addlast(val);
            }else{
                odd.addlast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        }else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        }else{
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    // using dummy node
    public void EvenOdd(){
        if (head == null) {
            return;
        }

        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node endEven = even;
        Node endOdd = odd;
        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                endEven.next = temp;
                endEven = endEven.next;
                
            }else{
                endOdd.next = temp;
                endOdd = endOdd.next;
            }

            temp = temp.next;
        }
        even = even.next;
        odd = odd.next;

        if (even == null || odd == null) {
            return;
        }

        head = odd;
        endOdd.next = even;
        endEven.next  = null;
    }


    public static void main(String[] args) {
        OddEvenLL ll =new OddEvenLL();
        ll.addlast(2);
        ll.addlast(9);
        ll.addlast(7);
        ll.addlast(6);
        ll.addlast(5);
        ll.addlast(4);
        ll.addlast(12);
        ll.addlast(3);
        ll.print();

        // ll.oddEven();
        // ll.print();

        ll.EvenOdd();
        ll.print();
    }
}