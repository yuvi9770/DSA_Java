package linkedList;

public class cycleRemoveSLL {

    public static Node head;
    public static Node tail;
    public static int size;

    // Print LL
    public static void print(){
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


    // removing cycle in LL
    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find new meeting point
        slow = head;
        Node prev = null;

        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // remove cycle
        if (slow == head) { //edge case where slow and fast points to head
            while (fast.next != head) {
                fast = fast.next;
            }
            fast.next = null;

        } else {
            prev.next = null;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(cycleDetectionSLL.isCycle(head));
        removeCycle();
        print();
    }
}