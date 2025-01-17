package BinaryTree;

public class InvertBinarytree {
    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node invert(Node root){
        if (root == null) {
            return null;
        }

        Node lNode = invert(root.left);
        Node rNode = invert(root.right);

        root.left = rNode;
        root.right = lNode;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrder(root);
        System.out.println();

        invert(root);
        preOrder(root);
    }
}