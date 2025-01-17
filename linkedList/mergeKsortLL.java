package linkedList;

import java.util.PriorityQueue;

public class mergeKsortLL {
    public Node head;
    public Node tail;
    public int size;

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

    // using divide and conquer method
    public Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data <= l2.data) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public Node partition(int start, int end, Node[] list) {
        if (start > end) return null;

        if (start == end) return list[start];

        int mid = (start + end)/2;
        Node l1 = partition(start, mid, list);
        Node l2 = partition(mid+1, end, list);

        return merge(l1, l2);
    }

    public Node mergeKList(Node[] list , int k) {
        if (list == null) return null;

        return partition(0, k-1, list);
    }


    // using priority Queue
    public Node mergeUsingPQ(Node[] list , int k) {
        if (list == null) return null;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            return a.data - b.data;
        });

        for (int i = 0; i < k; i++) {
            if (list != null) {
                pq.add(list[i]);
            }
        }
        Node dummy = new Node(-1);
        Node prev = dummy;

        while (pq.size() != 0) {
            prev.next = pq.poll();
            prev = prev.next;
            if (prev.next != null) {
                pq.add(prev.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        mergeKsortLL ll = new mergeKsortLL();
        int k = 3;
        Node[] Array = new Node[k];
      
        Array[0] = new Node(1);
        Array[0].next = new Node(9);
        Array[0].next.next = new Node(15);
        
        Array[1] = new Node(12);
        Array[1].next = new Node(24);
        Array[1].next.next = new Node(66);
        Array[1].next.next.next = new Node(78);
        
        Array[2] = new Node(0);
        Array[2].next = new Node(9);
        Array[2].next.next = new Node(10);
        Array[2].next.next.next = new Node(11);

        for (int i = 0; i < k; i++) {
            ll.print(Array[i]);
        }

        // Node res = ll.mergeKList(Array, k);

        Node res2 = ll.mergeUsingPQ(Array, k);
        if (res2 != null) {
            ll.print(res2);
        }
    }
}