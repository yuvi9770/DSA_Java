package BinaryTree;

public class SubTreeOfAnotherTree {

    public static boolean isIdentical(Node tNode, Node subRoot){
        if (tNode == null && subRoot == null) return true;

        else if (tNode == null || subRoot == null || tNode.data != subRoot.data){
            return false;
        }


        if (!isIdentical(tNode.left, subRoot.left)) return false;

        if (!isIdentical(tNode.right, subRoot.right)) return false;

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot){
        if (root == null) return false;
        
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
    public static void main(String[] args) {
        // tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // sub- tree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));
    }
}