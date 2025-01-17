package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;;

public class SortCharBYFreq {
    private class pair{
        char ch;
        int freq;
        public pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String sortChar(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            pq.offer(new pair(i.getKey(), i.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            pair p = pq.poll();

            while (p.freq-- > 0) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharBYFreq s = new SortCharBYFreq();

        System.out.println(s.sortChar("tree"));
    }
}