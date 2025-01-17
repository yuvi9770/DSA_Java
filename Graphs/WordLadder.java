package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                char temp[] = curr.toCharArray();

                for (int j = 0; j < curr.length(); j++) {
                    char orgChar = temp[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == orgChar) continue; 

                        temp[j] = ch;
                        String nWord = new String(temp);

                        if (nWord.equals(endWord)) {
                            return len+1;

                        }else if (wordSet.contains(nWord)) {
                            q.offer(nWord);
                            wordSet.remove(nWord);
                        }
                    }

                    temp[j] = orgChar;
                }
            }
            len++;
        }

        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");


        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}