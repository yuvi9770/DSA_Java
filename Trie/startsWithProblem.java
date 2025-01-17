package Trie;

public class startsWithProblem {
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

    public boolean startWith(String prefix){
        Node curr = root;
        for (int level = 0; level < prefix.length(); level++) {
            int idx = prefix.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        startsWithProblem ss = new startsWithProblem();

        String words[] = {"apple", "app", "mango", "man", "woman"};
        for (int i = 0; i < words.length; i++) {
            ss.insert(words[i]);
        }

        System.out.println(ss.startWith("app"));
        System.out.println(ss.startWith("moon"));
    }
}