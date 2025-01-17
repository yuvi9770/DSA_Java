package linkedList;

public class MergeSortSLL {

    public Node head;
    public Node tail;

    // Add data at first
    public void addFirst(int data){
        Node newNode = new Node(data);
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


    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }    
        }

        // Append the remaining nodes in temp
        if (head1 != null) {
            temp.next = head1;

        } else if (head2 != null) {
            temp.next = head2;
        }
        // while (head1 != null) {
        //     temp.next = head1;
        //     head1 = head1.next;
        //     temp = temp.next;
        // }

        // while (head2 != null) {
        //     temp.next = head2;
        //     head2 = head2.next;
        //     temp = temp.next;
        // }

        return mergeLL.next;
    }
    
    // merge using recursion
    
    // private Node merge(Node left, Node right) {
    //     if (left == null) return right;
    //     if (right == null) return left;
    //     Node result;
    //     if (left.data <= right.data) {
    //         result = left;
    //         result.next = merge(left.next, right);
    //     } else {
    //         result = right;
    //         result.next = merge(left, right.next);
    //     }
    //     return result;
    // }


    public Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        MergeSortSLL ll = new MergeSortSLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(0);
        ll.addFirst(4);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.print();
        // MergeSortOnLL.head = ll.mergeSort(MergeSortOnLL.head); it is used when head is static
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}