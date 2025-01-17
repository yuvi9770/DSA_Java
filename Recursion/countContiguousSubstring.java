package Recursion;

public class countContiguousSubstring {
    public static int subString(String str, int start, int end, int len){
        if (len == 1 || len == 0) {
            return len;
        }
        
        int res = subString(str, start+1, end, len-1)+
                  subString(str, start, end-1, len-1)-
                  subString(str, start+1, end-1, len-2);

        if (str.charAt(start) == str.charAt(end)) {
            res ++;
        }

        return res;     
    }

    public static void main(String[] args) {
        String str = "abcab"; //a,b,c,abca,bcab,a,b
        int len = str.length();
        System.out.println(subString(str, 0, len - 1, len));
        
    }
}