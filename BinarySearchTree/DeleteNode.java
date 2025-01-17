package BinarySearchTree;

public class DeleteNode {
    public static void inOrder(Node root){
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node delete(Node root, int val){
        if (root.data < val) {
            root.right = delete(root.right, val);

        }else if (root.data > val) {
            root.left = delete(root.left, val);

        }else{
            // case 1 : No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 : Single child
            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;
            }

            // case 3 : Both Children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);

        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        inOrder(root);
        System.out.println();

        delete(root, 1);
        inOrder(root);
        System.out.println();

        delete(root, 11);
        inOrder(root);
        System.out.println();

        delete(root, 5);
        inOrder(root);
        System.out.println();
    }
}