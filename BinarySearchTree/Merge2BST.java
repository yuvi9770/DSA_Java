package BinarySearchTree;

import java.util.ArrayList;

public class Merge2BST {
    public static void InOrder(Node root){
        if (root == null) return;

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void getInOrder(Node root, ArrayList<Integer> Arr){
        if (root == null) return;

        getInOrder(root.left, Arr);
        Arr.add(root.data);
        getInOrder(root.right, Arr);
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> Arr1, ArrayList<Integer> Arr2){
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < Arr1.size() && j < Arr2.size()) {
            result.add(Arr1.get(i) < Arr2.get(j) ? Arr1.get(i++) : Arr2.get(j++));
        }

        while (i < Arr1.size()) {
            result.add(Arr1.get(i++));
        }

        while (j < Arr2.size()) {
            result.add(Arr2.get(j++));
        }

        return result;
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if (start > end) return null;

        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node MergeBST(Node root1, Node root2){
        // step 1 : get inorder
        ArrayList<Integer> Arr1 = new ArrayList<>();
        getInOrder(root1, Arr1);

        // step 2 : get inorder
        ArrayList<Integer> Arr2 = new ArrayList<>();
        getInOrder(root2, Arr2);

        // merge Arr1 and Arr2
        ArrayList<Integer> res = sort(Arr1, Arr2);

        // sorted ArrayList to balanced BST
        return createBST(res, 0, res.size()-1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = MergeBST(root1, root2);
        InOrder(root);
    }
}