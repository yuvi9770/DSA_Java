package linkedList;

public class AddTwoLL {
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

    // Add data of two linkedList
    public int helper(Node one, int pv1, Node two, int pv2, AddTwoLL res){
        if (one == null && two == null) {
            return 0;
        }
        int data = 0;

        if (pv1 > pv2) {
            int oc = helper(one.next, pv1 - 1, two, pv2, res);
            data = one.data + oc;
            
        }else if (pv1 < pv2) {
            int oc = helper(one, pv1, two.next, pv2 - 1, res);
            data = two.data + oc;
     
        }else{
            int oc = helper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            data = one.data + two.data + oc;
        }

        int nd = data % 10;
        int nc = data / 10;
        res.addFirst(nd);

        return nc;
    }
    public AddTwoLL addLL(AddTwoLL one, AddTwoLL two){
        AddTwoLL res = new AddTwoLL();
        
        int oc = helper(one.head, one.size, two.head, two.size, res);
        if (oc > 0) {
            res.addFirst(oc);
        }

        return res;
    }


    public static void main(String[] args) {
        AddTwoLL one = new AddTwoLL();
        one.addFirst(5);
        one.addFirst(8);
        one.addFirst(9);
        one.addFirst(9);
        one.print();

        AddTwoLL two = new AddTwoLL();
        two.addFirst(6);
        two.addFirst(9);
        two.print();

        AddTwoLL result = new AddTwoLL();
        result = result.addLL(one, two);
        result.print();
    }
}