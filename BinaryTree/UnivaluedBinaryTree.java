package BinaryTree;

public class UnivaluedBinaryTree {

    public static boolean isuniValue(Node root){
        if (root == null) return true;

        if (root.left != null && root.data != root.left.data) {
            return false;
        }

        
        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        return isuniValue(root.left) && isuniValue(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.right = new Node(1);

        // data at every node must be same
        System.out.println(isuniValue(root));
    }
}