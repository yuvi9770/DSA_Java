package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class info2{
    Node node;
    int hd; // horizontal distance

    public info2(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfTree {
    public static void topView(Node root){
        if (root == null) return;

        // Level order travel
        Queue<info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new info2(root, 0));

        while (!q.isEmpty()) {
            info2 curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new info2(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }

            if (curr.node.right != null) {
                q.add(new info2(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        topView(root);
    }
}