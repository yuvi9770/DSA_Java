package BinarySearchTree;

public class RangeSum {

    public static int rSum(Node root, int low , int high){
        if (root == null) return 0;

        if (low < root.data && high < root.data) {
            return rSum(root.left, low, high);

        }else if (low > root.data && high > root.data) {
            return rSum(root.right, low, high);

        }else {
            return root.data + rSum(root.left, low, high) + rSum(root.right, low, high);
        }
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

        int sum = rSum(root, 5, 12);
        System.out.println(sum);
    }
}