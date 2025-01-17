package BinarySearchTree;

public class KthSmallestElementBST {
    static int res;
    static int count;

    
    public static void inOrder(Node root, int key){
        if (root == null) {
            return;
        }

        inOrder(root.left, key);
        if (++count == key) {
            res = root.data;
            return;
        }
        inOrder(root.right, key);

    }

    public static int kthSmallest(Node root, int key){
        count = 0;
        res = -1;
        inOrder(root, key);
        return res;
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

        System.out.println(kthSmallest(root, 3));
    }
}