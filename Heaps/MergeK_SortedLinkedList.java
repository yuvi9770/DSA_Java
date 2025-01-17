package Heaps;

import java.util.PriorityQueue;

class Node{
    int data;
    Node next;

    public Node(int data){
       this.data = data;
       this.next = null; 
    }
}

public class MergeK_SortedLinkedList {
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
            Node nNode = pq.poll();
            prev.next = nNode;
            prev = prev.next;
            
            if (nNode.next != null) {
                pq.add(nNode.next);
            }
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        MergeK_SortedLinkedList ll = new MergeK_SortedLinkedList();
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

        Node res2 = ll.mergeUsingPQ(Array, k);
        if (res2 != null) {
            ll.print(res2);
        }
    }
}