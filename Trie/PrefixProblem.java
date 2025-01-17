package Trie;

import java.util.*;

public class PrefixProblem {
    public Node root = new Node();

    public void insert(String word){
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            }
            curr.children[idx].freq++;
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public void helper(Node root, StringBuilder ans, List<String> result){
        if (root == null) return;

        if (root.freq == 1) {
            result.add(ans.toString());
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                ans.append((char)(i + 'a'));
                helper(root.children[i], ans, result);
                ans.deleteCharAt(ans.length() - 1);
            }
        }
    }

    public String[] findPrefix(Node root){
        List<String> result = new ArrayList<>();
        helper(root, new StringBuilder(), result);

        return result.toArray(new String[result.size()]);
    }
    
     public static void main(String[] args) {
        PrefixProblem pp = new PrefixProblem();

        String arr[] = {"zebra", "dog", "duck", "dove"};
        for (int i = 0; i < arr.length; i++) {
            pp.insert(arr[i]);
        }
        // pp.root.freq = -1;

        String[] prefixes = pp.findPrefix(pp.root);
        for (String pre : prefixes) {
            System.out.println(pre);
        }
    }
}