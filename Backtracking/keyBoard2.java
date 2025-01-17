package Backtracking;

public class keyBoard2 {
    static char[][] L = {
        {},{'.'},{'a','b','c'},{'d','e','f'},{'g','h','i'},
        {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
        {'t','u','v'},{'w','x','y','z'}
    };


    public static void solution(String str, int n, int currPos, StringBuilder sb){
        if (n == currPos) {
            System.out.println(sb);
            return;
        }
        /* str.charAt(currPos): it retrieve the string value at current position
        Character.getNumericValue(): it Convert the character to its numeric value
        */
        char[] letter = L[Character.getNumericValue(str.charAt(currPos))];
        for (int i = 0; i < letter.length; i++) {
            solution(str, n, currPos+1, sb.append(letter[i]));
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void combination(String str){
        int n = str.length();
        if (n == 0) {
            System.out.println("");
            return;
        }
        solution(str, n, 0, new StringBuilder());
    }
    public static void main(String[] args) {
      combination("23");  
    }
}