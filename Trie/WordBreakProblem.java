package Trie;

public class WordBreakProblem {
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

    public boolean wordBreak(String str){
        if (str.isEmpty()) return true; // str.length() == 0

        for (int i = 0; i < str.length(); i++) {
            String curr = str.substring(0, i+1);

            if (search(curr) && wordBreak(str.substring(i+1))) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        WordBreakProblem wb= new WordBreakProblem();

        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for (int i = 0; i < words.length; i++) {
            wb.insert(words[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wb.wordBreak(key));
        System.out.println(wb.wordBreak("ilikesamg"));
    }
}