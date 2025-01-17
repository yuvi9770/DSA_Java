package BinarySearchTree;

// leetcode - 538, 1038 and gfg with slight difference

public class BST_to_GreaterSumTree {
    public static void InOrder(Node root){
        if (root == null) return;

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    static int sum = 0;

    public static Node solve(Node root){
        if (root == null) return null;

        solve(root.right);
        sum += root.data;
        root.data = sum;
        // root.data = sum - root.data; // this is a slight difference in gfg where the value of current node is not add

        solve(root.left);

        return root;
    }

    public static Node greaterTree(Node root){
        sum = 0;
        return solve(root);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);

        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        InOrder(root);
        System.out.println();

        Node root2 = greaterTree(root);
        InOrder(root2);
    }
}