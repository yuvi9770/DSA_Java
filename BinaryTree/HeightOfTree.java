package BinaryTree;

public class HeightOfTree {
    public static int height(Node root){
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        
        return Math.max(lheight, rheight)+1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(height(root));
    }
}