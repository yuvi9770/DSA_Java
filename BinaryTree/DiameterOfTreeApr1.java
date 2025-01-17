package BinaryTree;

public class DiameterOfTreeApr1 {

    public static int height(Node root){
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        
        return Math.max(lheight, rheight)+1;
    }
    
    public static int diameter(Node root){
        if (root == null) return 0;

        int leftDiam = diameter(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.right = new Node(56);
        root.left.right.right.right = new Node(21);
        root.left.right.right.right.right = new Node(78);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    }
}