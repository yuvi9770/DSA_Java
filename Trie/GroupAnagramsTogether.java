package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsTogether {
    // Approach 2 : n * k
    public static String generateKey(String str){
        int count[] = new int[26];

        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(count[i]);
        }
        return sb.toString();
    }

    public static List<List<String>> grp(String str[]){
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            String key = generateKey(s);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    // Approach 1 : n * klog(k)
    public static List<List<String>> grpAna(String str[]){
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> res = grp(strs);
        System.out.println(res);
    }
}