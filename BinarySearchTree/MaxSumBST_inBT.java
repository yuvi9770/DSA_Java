package BinarySearchTree;

class info2{
    boolean isBST;
    int sum;
    int min;
    int max;
    public info2(boolean isBST, int sum, int min, int max) {
        this.isBST = isBST;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}

public class MaxSumBST_inBT {
    static int maxSum = 0;

    public static info2 Solve(Node root){
        if (root == null) {
            return new info2(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.data);
            return new info2(true, root.data, root.data, root.data);
        }
        
        info2 left = Solve(root.left);
        info2 right = Solve(root.right);

        int currSum = left.sum + right.sum + root.data;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (left.isBST && right.isBST && left.max < root.data && right.min > root.data) {
            maxSum = Math.max(maxSum, currSum);
            return new info2(true, currSum, min, max);
        }
        
        return new info2(false, Math.max(left.sum, right.sum), min, max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // Solve(root);
        // System.out.println(maxSum);

        root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        Solve(root);
        System.out.println(maxSum);

    }
}