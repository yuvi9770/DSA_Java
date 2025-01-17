package Strings;

import java.util.HashMap;

public class AnagramUsingHashMap {
    public static HashMap<Character,Integer> charFreq(String str){
        HashMap<Character,Integer> Map = new HashMap<>();
        for (char i  : str.toCharArray()) {
            Map.put(i, Map.getOrDefault(i, 0)+1);
        }
        return Map;

    }

    public static void checker(String str, String str1){
        str = str.toLowerCase();
        str1 = str1.toLowerCase();

        if (str.length() != str1.length()) {
            System.out.println("No, it is not Anagram");
            return;
        }

        HashMap<Character,Integer> Map1 = charFreq(str);
        HashMap<Character,Integer> Map2 = charFreq(str1);

        if (Map1.equals(Map2)) {
            System.out.println("Yes, it is Anagram");
        } else {
            System.out.println("No, it is not Anagram");
        }
    }

    public static void main(String[] args) {
        String str = "Race";
        String str1 = "Care";
        checker(str, str1);
    }
}