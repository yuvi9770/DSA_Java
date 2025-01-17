package BinarySearchTree;

import java.util.ArrayList;

public class Root_toLeaf_Path {
    public static void printPath(ArrayList<Integer> path){
        for (Integer i : path) {
            System.out.print(i + "-> ");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null) return;

        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1); // remove last element

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(6);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(4);

        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        printRoot2Leaf(root, new ArrayList<>());
    }
}