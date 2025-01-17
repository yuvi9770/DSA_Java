package BinarySearchTree;

public class ClosestElement_inBST {

    public static int solve(Node root, double target, double minDiff, int closeVal){
        if (root == null) return closeVal;

        // base condition when target is equal to root.data
        if (root.data == target) return root.data;

        if (Math.abs(target - root.data) < minDiff) {
            minDiff = Math.abs(target - root.data);
            closeVal = root.data;
        }

        if (target > root.data) {
            return solve(root.right, target, minDiff, closeVal);

        } else {
            return solve(root.left, target, minDiff, closeVal);
        }
    }

    public static int close(Node root, int target){
        return solve(root, target, Double.MAX_VALUE, root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);

        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        System.out.println(close(root, 5));
        System.out.println(close(root, 12));
        System.out.println(close(root, 0));
    }
}