package BinarySearchTree;

public class MirrorOf_BST {
    public static void InOrder(Node root){
        if (root == null) return;

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node MirrorImage(Node root){
        if (root == null) return null;

        Node lNode = MirrorImage(root.left);
        Node rNode = MirrorImage(root.right);

        root.left = rNode;
        root.right = lNode;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        InOrder(root);
        System.out.println();

        MirrorImage(root);
        preOrder(root);
    }
}