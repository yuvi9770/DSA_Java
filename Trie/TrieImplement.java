package Trie;

public class TrieImplement {
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

    public boolean search(String key){
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static void main(String[] args) {
        TrieImplement ti= new TrieImplement();

        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            ti.insert(words[i]);
        }
        
        System.out.println(ti.search("thee"));
        System.out.println(ti.search("th"));
        System.out.println(ti.search("thor"));
    }
}