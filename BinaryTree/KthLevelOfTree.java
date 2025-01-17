package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevelOfTree {
    public static void iterative(Node root, int k){
        if (root == null) return;

        int level = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                level++;

                if (q.isEmpty()) break; 

                else q.add(null);

            } else {
                if (level == k) {
                    System.out.print(currNode.data + " ");
                }

                if (currNode.left != null) q.add(currNode.left);

                if (currNode.right != null) q.add(currNode.right); 
            }
        }
    }

    public static void recur(Node root, int level, int k){
        if (root == null) return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        recur(root.left, level+1, k);
        recur(root.right, level+1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        iterative(root, 3);
        System.out.println();

        recur(root, 1, 3);
    }
}