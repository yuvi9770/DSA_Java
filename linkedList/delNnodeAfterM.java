package linkedList;

public class delNnodeAfterM {
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


    public void deleteNodes(Node head, int n, int m){
        Node curr = head;
        Node temp;

        while (curr != null) {
            // travel m Nodes
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) return;

            // travel n Nodes
            temp = curr.next;
            for (int i = 1; i <= n; i++) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 2;

        delNnodeAfterM ll = new delNnodeAfterM();
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
        ll.print();

        ll.deleteNodes(ll.head, n, m);
        ll.print();
    }
}