package BinarySearchTree;

public class Search_inBST {

    public static boolean isFound(Node root, int key){
        if (root == null) return false;

        if (root.data == key) return true;

        if (root.data > key) {
            return isFound(root.left, key);
            
        }else{
            return isFound(root.right, key);
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

        System.out.println(isFound(root, 1));
        System.out.println(isFound(root, 11));
        System.out.println(isFound(root, 7));
    }
}