package Trie;

public class UniqueSubStr {
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

    public void SUFFIX(String str){
        for (int i = 0; i < str.length(); i++) {
            String Suffix = str.substring(i);
            insert(Suffix);
        }
    }

    public int countNode(Node root){
        if (root == null) return 0;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += countNode(root.children[i]);
        }

        return count+1;
    }

    public static void main(String[] args) {
        UniqueSubStr un = new UniqueSubStr();

        String str = "ababa";

        // find suffix and add to trie
        un.SUFFIX(str);
        System.out.println(un.countNode(un.root));
    }
}