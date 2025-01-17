package Recursion;

public class RemoveDuplicateExtra {
    public static void duplicate(String str, int idx, StringBuilder sb, boolean map[]){
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }

        char currChar = str.charAt(idx);
        // handle all value rather then char to go into infinie recursion
        if (currChar >= 'a' && currChar <='z') {
            if (map[currChar - 'a'] == true) {
                duplicate(str, idx+1, sb, map); 
            } else {
                map[currChar - 'a'] = true;
                duplicate(str, idx+1, sb.append(currChar), map);
            }
        } else {
            duplicate(str, idx+1, sb, map);
        }

    }
    public static void main(String[] args) {
        String str = "apppnacoll  egeis@$$%kbmkgmn";
        duplicate(str, 0, new StringBuilder(""), new boolean[25]);
    }
}