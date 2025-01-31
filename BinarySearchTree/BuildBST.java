package BinarySearchTree;

public class BuildBST {
    public static void inOrder(Node root){
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node insert(Node root, int val){
        if (root == null) return new Node(val);

        if (root.data > val) // left subTree
        root.left = insert(root.left, val);
        
        if (root.data < val) // right subTree
        root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }

        inOrder(root);
    }
}