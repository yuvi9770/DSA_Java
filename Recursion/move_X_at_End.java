package Recursion;

public class move_X_at_End {
    
    public static void printX(String str, int idx, int count, StringBuilder sb){
        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                sb.append('x');
            }
            System.out.println(sb);
            return;
        }

        char currchar = str.charAt(idx);
        if (currchar == 'x') {
            count++;
        }else{
            sb.append(currchar);
        }

        printX(str, idx+1, count, sb);
    }

    public static void main(String[] args) {
        printX("axbcxxd", 0, 0, new StringBuilder());
    }
}