package BinarySearchTree;

import java.util.ArrayList;

public class BST_toBalancedBST {

    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInOrder(Node root, ArrayList<Integer> Arr){
        if (root == null) return;

        getInOrder(root.left, Arr);
        Arr.add(root.data);
        getInOrder(root.right, Arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if (start > end) return null;

        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node balancedBst(Node root){
        // find inOrder seq
        ArrayList<Integer> Arr1 = new ArrayList<>();
        getInOrder(root, Arr1);

        // sorted inorder -> balanced BST
        return createBST(Arr1, 0, Arr1.size()-1);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBst(root);
        preOrder(root);
    }
}