package Recursion;

public class subSequenceOfString {
    public static void subSeq(String str, int idx, String newStr){
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // char present
        subSeq(str, idx+1, newStr + str.charAt(idx));

        // char not present
        subSeq(str, idx+1, newStr);
    }
    public static void main(String[] args) {
        subSeq("abc", 0, "");
    }
}
