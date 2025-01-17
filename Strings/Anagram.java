package Strings;

import java.util.Arrays;

public class Anagram {

    public static void anagram_check(String str, String str1){
        str = str.toLowerCase();
        str1 = str1.toLowerCase();

        if (str.length() == str1.length()) {
            char[] strArray = str.toCharArray();
            char[] str1Array = str1.toCharArray();

            Arrays.sort(strArray);
            Arrays.sort(str1Array);

            if (Arrays.equals(strArray, str1Array)) {
                System.out.println("Yes, it is Anagram");
            } else {
                System.out.println("No, it is not Anagram"); 
            }

        } else {
            System.out.println("No, it is not Anagram");
        }
    }

    public static void main(String[] args) {
        String str = "Raace";
        String str1 = "Care";
        anagram_check(str, str1);
    }
}