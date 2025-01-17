package Graphs;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MinDepthOfBinaryTree {
    public static int dfs(Node root){
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }


    private static class item{
        Node node;
        int depth;
        public item(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static int bfs(Node root){
        if (root == null) return 0;

        Queue<item> q = new LinkedList<>();
        q.add(new item(root, 1));

        while (!q.isEmpty()) {
            item curr = q.remove();
            Node currNode = curr.node;
            int height = curr.depth;

            if (currNode.left == null && currNode.right == null) {
                return height;

            }else{
                if (currNode.left != null) {
                    q.add(new item(currNode.left, height+1));
                }
    
                if (currNode.right != null) {
                    q.add(new item(currNode.right, height+1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(5);

        System.out.println(dfs(root));

        System.out.println(bfs(root));
    }
}