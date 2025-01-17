package Hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class info{
    Node node;
    int hd;
    public info(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomViewOfBinaryTree {

    public static void bottom(Node root){
        if (root == null) return;

        HashMap<Integer, Node> map = new HashMap<>();
        Queue<info> q = new LinkedList<>();

        q.add(new info(root, 0));
        int min = 0, max = 0;
        
        while (!q.isEmpty()) {
            info curr = q.remove();

            map.put(curr.hd, curr.node);

            if (curr.node.left != null) {
                q.add(new info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
                
            if (curr.node.right != null) {
                q.add(new info(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right = new Node(22);
        root.right.right = new Node(25);

        bottom(root);
    }
}