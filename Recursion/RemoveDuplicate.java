package Recursion;

public class RemoveDuplicate {
    public static void remove(String str, int idx, StringBuilder sb, boolean map[]){
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            remove(str, idx + 1, sb, map);
        }else{
            map[currChar - 'a'] = true;
            remove(str, idx + 1, sb.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "appnacollege";
        StringBuilder sb = new StringBuilder();
        
        remove(str, 0, sb, new boolean[26]);
    }
}