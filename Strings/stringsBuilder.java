package Strings;

public class stringsBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);  
    }
}