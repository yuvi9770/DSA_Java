package Backtracking;

public class permutation {
    public static void findPer(String str, String newStr){
        if (str.length() == 0){
            System.out.println(newStr);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String leftStr = str.substring(0, i) + str.substring(i+1);
            findPer(leftStr, newStr + str.charAt(i));
        }
    }
    
    public static void main(String[] args) {
       String str = "abc"; 
       findPer(str,"");
    }
}