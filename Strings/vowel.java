package Strings;

public class vowel {
    public static void distinct(String str){
        int count = 0;

        for (char i : str.toCharArray()) {
            if (i == 'a' || i == 'e' || i == 'o' || i == 'u' || i == 'i') {
                System.out.print(i);
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args) {
        String str = "hllo world i am good";
        distinct(str);
    }
}