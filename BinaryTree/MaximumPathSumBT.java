package BinaryTree;

public class MaximumPathSumBT {
    static int maxSum;

    public static int solve(Node root){
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int curvePath = left + right + root.data;

        int straightPath = Math.max(root.data, (Math.max(left, right) + root.data));

        maxSum = Math.max(maxSum, Math.max(curvePath, straightPath));
        
        return straightPath;
    }

    public static int maxPath(Node root){
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxPath(root));
    }
}