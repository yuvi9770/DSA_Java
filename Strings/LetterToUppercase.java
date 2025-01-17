package Strings;

public class LetterToUppercase {
    public static void betterWay(String str){
        StringBuilder sb = new StringBuilder();
        boolean capital = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(' ');
                capital = true;
            } else {
                if (capital == true) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    capital = false;
                } else {
                    sb.append(str.charAt(i));  
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void upparLetter(String str){
        //if there is even space after a word it will not work properly
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()-1 ) {
                sb.append(' ');
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "hello,  hoW arE yUo";
        betterWay(str);
        upparLetter(str);
    }
}