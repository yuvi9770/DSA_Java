package BinaryTree;

public class KthAncestor {
    public static int kAnces(Node root, int n, int k){
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftDist = kAnces(root.left, n, k);
        int rightDist = kAnces(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist)+1;
        if (max == k) {
            return root.data; // value at the kth Ancestor
        }

        return max; // distance
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(kAnces(root, 5, 2));
    }
}