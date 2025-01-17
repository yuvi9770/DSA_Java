package DynamicProgramming;

public class PrintCombOfBalanceParanthesis {
    //this is Recursion question not DP

    //Approach -> 1
    public static boolean isValid(StringBuilder sb){
        int sum = 0;
        String res  = sb.toString();
        
        for (char ch : res.toCharArray()) {
            if (ch == '(') {
                sum++;
            }else{
                sum--;
            }

            if (sum < 0) return false;
        }
        return sum == 0;
    }

    public static void generate(int n, StringBuilder sb){
        if(sb.length() == 2*n){
            if (isValid(sb)) {
                System.out.println(sb);
            }
            return;
        }

        sb.append("(");
        generate(n, sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append(")");
        generate(n, sb);
        sb.deleteCharAt(sb.length()-1);
    }


    //Approach -> 2 (Better)
    public static void generate2(int n, int open, int close, StringBuilder sb){
        if(sb.length() == 2*n){
            System.out.println(sb);
            return;
        }

        if (open < n) {
            sb.append("(");
            generate2(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < open) {
            sb.append(")");
            generate2(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n, new StringBuilder());
        System.out.println();
        
        generate2(n, 0, 0, new StringBuilder());
    }
}
