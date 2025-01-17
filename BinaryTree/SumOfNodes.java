package BinaryTree;

public class SumOfNodes {
    public static int Sum(Node root){
        if (root == null) return 0;

        int lSum = Sum(root.left);
        int rSum = Sum(root.right);
        
        return lSum + rSum + root.data;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(Sum(root));
    }
}