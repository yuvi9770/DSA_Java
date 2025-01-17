package BinaryTree;

public class CountOfNodes {
    public static int count(Node root){
        if (root == null) return 0;

        int lCount = count(root.left);
        int rCount = count(root.right);
        
        return lCount + rCount + 1;
    } 
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(count(root));
    }
}