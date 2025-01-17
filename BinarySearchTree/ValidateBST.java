package BinarySearchTree;

public class ValidateBST {

    public static boolean isValid(Node root, long min, long max){
        if (root == null) return true;

        if (root.data <= min || root.data >= max) return false;

        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }

    public static boolean solve(Node root){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);
        System.out.println(solve(root));

        root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        System.out.println(solve(root));
    }
}