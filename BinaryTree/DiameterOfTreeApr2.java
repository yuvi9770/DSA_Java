package BinaryTree;

class Info{
    int diam;
    int ht;

    public Info(int diam, int ht) {
        this.diam = diam;
        this.ht = ht;
    } 
}

public class DiameterOfTreeApr2 {
    public Info diameter2(Node root){
        if (root == null) return new Info(0, 0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), (rightInfo.ht + leftInfo.ht + 1));
        int ht = Math.max(rightInfo.ht, leftInfo.ht)+1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.right = new Node(56);
        root.left.right.right.right = new Node(21);
        root.left.right.right.right.right = new Node(78);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        
        DiameterOfTreeApr2 d2 = new DiameterOfTreeApr2();

        System.out.println(d2.diameter2(root).diam);
        System.out.println(d2.diameter2(root).ht);
    }
}