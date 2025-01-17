package Stacks;

import java.util.Stack;

public class decodeString {
    // using one stack and stringBuilder type
    public static String decode4(String str){
        Stack<Object> st = new Stack<>();
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num*10) + (c -'0');

            }else if (c == '[') {
                st.push(currStr);
                currStr = new StringBuilder();

                st.push(num);
                num = 0;

            }else if (c == ']') {
                int rep = (int)st.pop();
                StringBuilder sb = new StringBuilder((StringBuilder) st.pop()); // Pop from Stack as StringBuilder

                while (rep-- > 0) {
                    sb.append(currStr);
                }
                currStr = sb;

            }else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }

    // using one stack and string type
    public static String decode3(String str){
        Stack<Object> st = new Stack<>();
        
        int num = 0;
        String currStr = "";

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num*10) + (c -'0');

            }else if (c == '[') {
                st.push(currStr);
                currStr = "";

                st.push(num);
                num = 0;

            }else if (c == ']') {
                int rep = (int)st.pop();
                // String prevStr = (String) st.pop();// Pop as String from Stack
                StringBuilder sb = new StringBuilder((String) st.pop()); // Pop as String from Stack and Convert to StringBuilder

                while (rep-- > 0) {
                    sb.append(currStr);
                }
                currStr = sb.toString();

            }else{
                currStr += c;
            }
        }
        
        return currStr;
    }

    // using two stack and stringBuilder type
    public static String decode2(String str){
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) { // (c >'0' && c < '9')
                num = (num*10) + (c -'0');

            }else if (c == '[') {
                numSt.push(num);
                num = 0;

                strSt.push(currStr);
                currStr = new StringBuilder();

            }else if (c == ']') {
                StringBuilder prevStr = new StringBuilder(strSt.pop());// pop str from Stack
                int rep = numSt.pop();

                while (rep-- > 0) {
                    prevStr.append(currStr);
                }
                currStr = prevStr;

            }else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }

    // using two stack and string type
    public static String decode1(String str){
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        
        int num = 0;
        String currStr = "";

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num*10) + (c -'0');

            }else if (c == '[') {
                numSt.push(num);
                num = 0;

                strSt.push(currStr);
                currStr = "";

            }else if (c == ']') {
                StringBuilder prevStr = new StringBuilder(strSt.pop());// pop str from Stack
                int rep = numSt.pop();

                while (rep-- > 0) {
                    prevStr.append(currStr);
                }
                currStr = prevStr.toString();

            }else{
                currStr += c;
            }
        }
        
        return currStr;
    }
    public static void main(String[] args) {
        String str = "2[cv]";
        String str2 = "3[b2[v]]l";
        String str3 = "2[a3[c2[x]]y]";

        // System.out.println(decode1(str));
        // System.out.println(decode1(str2));
        // System.out.println(decode1(str3));

        // System.out.println(decode2(str));
        // System.out.println(decode2(str2));
        // System.out.println(decode2(str3));

        System.out.println(decode3(str));
        System.out.println(decode3(str2));
        System.out.println(decode3(str3));

        System.out.println(decode4(str));
        System.out.println(decode4(str2));
        System.out.println(decode4(str3));
    }
}