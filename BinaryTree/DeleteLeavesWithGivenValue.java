package BinaryTree;

public class DeleteLeavesWithGivenValue {
    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node deleteVal(Node root, int target){
        if (root == null) return null;

        root.left = deleteVal(root.left, target);
        root.right = deleteVal(root.right, target);

        if (root.left == null && root.right == null && root.data == target) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        preOrder(root);
        System.out.println();
        deleteVal(root, 3);
        preOrder(root);
        System.out.println();


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        
        preOrder(root);
        System.out.println();
        deleteVal(root, 2);
        preOrder(root);
        System.out.println();
    }
}