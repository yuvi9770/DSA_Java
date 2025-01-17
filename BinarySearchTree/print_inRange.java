package BinarySearchTree;

public class print_inRange {

    public static void printRange(Node root, int low, int high){
        if (root == null) return;

        if (low < root.data && high < root.data) {
            printRange(root.left, low, high);

        }else if (low > root.data && high > root.data) {
            printRange(root.right, low, high);

        }else {
            printRange(root.left, low, high);
            System.out.print(root.data + " ");
            printRange(root.right, low, high);
        }
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

        printRange(root, 5, 12);
    }
}