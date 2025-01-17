package linkedList;

public class addSLL {
    
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
        Node newNode = new Node(data); //create newNode
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


    // Add data at Middle/given idx
    public void add(int idx, int data){
        if (idx < 0 || idx > size) {
            System.out.println("Index is not valid");
            return;

        }else if (idx == 0) {
            addFirst(data);
            return;

        }else if (idx == size) {
            addlast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;

            if (temp.next == null) {
                System.out.println("not possible to add at given index");
                return;
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;
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


    // remove data at last
    public int removeLast(){
        if (size == 0) {
            System.out.println("It is already empty can't remove");
            return -1;

        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    // remove data at given Index
    public int removeIdx(int idx){
        if (idx < 0 || idx >= size) {
            System.out.println("Index is not valid");
            return -1;

        }else if (size == 0) {
            System.out.println("List is empty, cannot remove element");
            return -1;
            
        }else if (idx == 0) {
            return removeFirst();

        }else if (idx == size-1) {
            return removeLast();
            
        }

        Node prev = head;
        for (int i = 0; i < idx-1; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }


    // remove data by value
    public int removeValue(int val){
        if (size == 0) {
            System.out.println("List is empty, cannot remove element");
            return -1;

        }else if (head.data == val) {
            return removeFirst();

        }

        Node currNode = head.next;
        Node prev = head;

        while (currNode != null) {
            if (currNode.data == val) {
                if (currNode.next == null) {
                    return removeLast();

                }else{
                    prev.next = currNode.next;
                    size--;
                    return val;  
                }
            }
            prev = currNode;
            currNode = currNode.next;
        }

        System.out.println("Element not found in this list");
        return -1;
    }


    // iterative search 
    public int iterativeSearch(int key){
        if (size == 0) {
            System.out.println("List is empty, cannot remove element");
            return -1;
        }

        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }

        System.out.println("Element not found");
        return -1;
    }


    // recursive search
    public int helper(Node head, int key){
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
           return -1; 
        }

        return idx+1;
    }
    public int recursiveSearch(int key){
        if (size == 0) {
            System.out.println("List is empty, cannot remove element");
            return -1;
        }
        return helper(head, key);
    }


    // reverse a LL using next(Node)
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

        if (n <= 0) {
            return;
        }
        
        if (sz == n) {
            head = head.next; // remove First
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


    public static void main(String[] args) {
        addSLL ll = new addSLL();
        ll.print();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addlast(3);
        ll.addlast(4);
        ll.print();
        // ll.add(3, 9);
        // ll.print();

        // System.out.println(ll.size);

        // System.out.println(ll.removeFirst());
        // ll.print();

        // System.out.println(ll.removeLast());
        // ll.print();
        // System.out.println(ll.size);

        // System.out.println(ll.removeIdx(-5));
        // ll.print();
        // // System.out.println(tail.data);

        // ll.removeValue(9);
        // ll.print();
        // System.out.println(ll.tail.data);

        // System.out.println(ll.iterativeSearch(6));
        // System.out.println(ll.recursiveSearch(3));

        // ll.reverse();
        // ll.print();
        // System.out.println(ll.head.data);
        // System.out.println(ll.tail.data);

        ll.deleteNthfromEnd(4);
        ll.print();
    }
}