package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class BuildTree{
    static int idx = -1;

    public Node build(int nodes[]){
        idx++;
        if (nodes[idx] == -1) return null;

        Node newNode = new Node(nodes[idx]);
        newNode.left = build(nodes);
        newNode.right = build(nodes);

        return newNode;
    }
}

class TreeTraversal{
    public void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void InOrder(Node root){
        if (root == null) return;

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public void postOrder(Node root){
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level order tree traversal
    public void levelOrder(Node root){
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();

                if (q.isEmpty()) break; 

                else q.add(null);

            } else {
                System.out.print(currNode.data + " ");

                if (currNode.left != null) q.add(currNode.left);

                if (currNode.right != null) q.add(currNode.right); 
            }
        }
    }
}

public class BuildTreePreOrder {
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BuildTree tree = new BuildTree();
        Node root = tree.build(nodes);
        System.out.println(root.data);

        
        TreeTraversal t2 = new TreeTraversal();
        t2.preOrder(root);
        System.out.println();

        t2.InOrder(root);
        System.out.println();

        t2.postOrder(root);
        System.out.println();

        t2.levelOrder(root);
    }
}