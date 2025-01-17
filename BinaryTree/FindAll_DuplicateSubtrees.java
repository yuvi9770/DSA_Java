package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAll_DuplicateSubtrees {
    static Map<String, Integer> map;
    static List<Node> result;

    public static String traverse(Node root){
        if (root == null) return "N";

        String s = root.data + "," + traverse(root.left) + "," + traverse(root.right);

        map.put(s, map.getOrDefault(s, 0)+1);
        if (map.get(s) == 2) {
            result.add(root);
        }

        return s;
    }

    public static List<Node> findDuplicate(Node root){
        map = new HashMap<>();
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        List<Node> res = findDuplicate(root);
        for (Node i : res) {
            System.out.println(i.data);
        }
    }
}