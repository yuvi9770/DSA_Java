package Backtracking;

public class findSubSets {
    public static void subSets(String str, int i, StringBuilder sb){
        if (i == str.length()) {
            System.out.println(sb);
            return;
        }
        // character is present
        subSets(str, i+1, sb.append(str.charAt(i)));
        sb.deleteCharAt(sb.length()-1);
        
        // character is not present
        subSets(str, i+1, sb);
    }

    public static void main(String[] args) {
        String str = "abc";
        subSets(str, 0, new StringBuilder());
    }
}