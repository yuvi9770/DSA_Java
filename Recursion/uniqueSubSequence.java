package Recursion;

import java.util.HashSet;

public class uniqueSubSequence {
    public static void uniqSubSeq(String str, int idx, String newStr, HashSet<String> set){
        if (idx == str.length()) {
            if (set.contains(newStr)) {
                return;
            }else{
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }
        // char present
        uniqSubSeq(str, idx+1, newStr + str.charAt(idx), set);

        // char not present
        uniqSubSeq(str, idx+1, newStr, set);
    }
    
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        uniqSubSeq("aaa", 0, "", set);
    }
}