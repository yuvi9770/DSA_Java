package BinarySearchTree;

class Node2{
    int data;
    int height;
    Node2 left, right;

    Node2(int data){
        this.data = data;
        height = 1;
        left = null; right = null;
    }
}

public class AVLTree {
    static Node2 root;

    // cal height of tree
    public static int height(Node2 root){
        if (root == null) return 0;

        return root.height;
    }

    // subtree RightRotate
    public static Node2 rightRotate(Node2 y){
        Node2 x = y.left;
        Node2 T2 = x.right; // for first dry run it is null

        // perform rotation
        x.right = y;
        y.left = T2; // here 40 left become null

        // update height
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // subtree LeftRotate
    public static Node2 leftRotate(Node2 x){
        Node2 y = x.right;
        Node2 T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // update height
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        return y;
    }

    // get balance factor
    public static int getBalance(Node2 root){
        if (root == null) return 0;

        return height(root.left) - height(root.right);
    }

    // insert data to Tree
    public static Node2 insert(Node2 root, int data){
        if (root == null) return new Node2(data);

        if (data < root.data) {
            root.left = insert(root.left, data);

        }else if (data > root.data) {
            root.right = insert(root.right, data);

        }else{
            return root;
        }

        // update height of ancestor node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor of ancestor node 
        int bf = getBalance(root);

        // Left Left Case 
        if (bf > 1 && data < root.left.data) 
            return rightRotate(root); 

        // Right Right Case 
        if (bf < -1 && data > root.right.data) 
            return leftRotate(root); 

        // Left Right Case 
        if (bf > 1 && data > root.left.data) { 
            root.left = leftRotate(root.left); 
            return rightRotate(root); 
        } 

        // Right Left Case 
        if (bf < -1 && data < root.right.data) { 
            root.right = rightRotate(root.right); 
            return leftRotate(root); 
        } 

        return root;
    }
    
    public static void preOrder(Node2 root) { 
        if (root != null) { 
            System.out.print(root.data + " "); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 

    public static void main(String[] args) {
        root = insert(root, 40 ); 
        root = insert(root, 20); 
        root = insert(root, 10); 
        root = insert(root, 25); 
        root = insert(root, 30); 
        root = insert(root, 22);
        root = insert(root, 50); 

        preOrder(root);
    }
}