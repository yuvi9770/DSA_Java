package linkedList;

public class cycleDetectionSLL {

    public static Node head;
    public static Node tail;
    public static int size;

    // detecting cycle in LL
    public static boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true; // cycle exists
            }
        }
        return false;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(isCycle(head));
    }
}