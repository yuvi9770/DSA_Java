package Backtracking;

public class keyBoard {
    static String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printComb(String str, int idx, StringBuilder sb){
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printComb(str, idx+1, sb.append(mapping.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        } 
    }

    public static void main(String[] args) {
        printComb("23", 0, new StringBuilder());
    }
}