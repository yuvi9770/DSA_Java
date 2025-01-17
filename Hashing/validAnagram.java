package Hashing;

import java.util.HashMap;

public class validAnagram {

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        s = s.toLowerCase(); t = t.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer count = map.get(ch);

            if (count == null) return false;

            if (count == 1) map.remove(ch);
            
            else map.put(ch, count - 1);
        }
        
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Race", "care"));
        System.out.println(isAnagram("tulip", "lipid"));
    }
}