package Stacks;

import java.util.Stack;

// class Node{
//     int data;
//     Node next;

//     public Node(int data){
//        this.data = data;
//        this.next = null; 
//     }
// }

public class palindrome_LL {
    //it iterate till the mid of LL
    public static boolean isPalin2(Node head){
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        Stack<Integer> s = new Stack<>();

        while (fast != null && fast.next != null) {
            s.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != s.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    //it iterate on whole LL
    public static boolean isPalin(Node head){
        if (head == null || head.next == null) return true;

        Node slow = head;
        Stack<Integer> s = new Stack<>();

        while (slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            if (head.data != s.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        one.next = new Node(2);
        one.next.next = new Node(3);
        one.next.next.next = new Node(4);
        one.next.next.next.next = new Node(3);
        one.next.next.next.next.next = new Node(2);
        one.next.next.next.next.next.next = new Node(1);

        System.out.println(isPalin(one));
        System.out.println(isPalin2(one));
    }
}