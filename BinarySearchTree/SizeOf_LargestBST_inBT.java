package BinarySearchTree;

class info{
    boolean isBST;
    int size;
    int min;      
    int max;
    public info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    } 
}

public class SizeOf_LargestBST_inBT {
    static int maxBST = 0;
    
    public static info largestBST(Node root){
        if (root == null) {
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            //min = Integer.MAX_VALUE as we go on leaf node this will ensure that min val is adjust to root.data correctly
        }

        if (root.left == null && root.right == null) {
            return new info(true, 1, root.data, root.data);
        }

        info leftInfo = largestBST(root.left);
        info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size); // compare the size of BST
            return new info(true, size, min, max);
        }

        return new info(false, size, min, max); // if above cond. is False
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBST(root);
        System.out.println("Largest size : " + maxBST);
    }
}