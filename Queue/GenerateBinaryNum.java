package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNum {
    public static String[] binNum(int n){
        String res[] = new String[n];
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            res[i] = q.poll();

            q.offer(res[i] + "0");
            q.offer(res[i] + "1");
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        String ele[] = binNum(n);
        for (String str : ele) {
            System.out.print(str + " ");
        }
    }
}