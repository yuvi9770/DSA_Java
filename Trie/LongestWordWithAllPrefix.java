package Trie;

public class LongestWordWithAllPrefix {
    public Node root = new Node();

    public void insert(String word){
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String ans = "";

    public void longestWord(Node root, StringBuilder temp){
        if (root == null) return;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        LongestWordWithAllPrefix lw = new LongestWordWithAllPrefix();

        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (int i = 0; i < words.length; i++) {
            lw.insert(words[i]);
        }

        lw.longestWord(lw.root, new StringBuilder());

        System.out.println(ans);
    }
}