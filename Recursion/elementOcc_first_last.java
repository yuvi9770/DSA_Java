package Recursion;

public class elementOcc_first_last {
    static int first = -1;
    static int last = -1;

    public static void findOccr(String str, int idx, char key){
        if (idx == str.length()) {
            System.out.println("first: " + first);
            System.out.println("last: " + last);
            return;
        }

        char currchar = str.charAt(idx);
        if (currchar == key) {
            if (first == -1) {
                first = idx;
                last = idx; // if only 1 element is present
            }else {
                last = idx;
            }
        }
        
        findOccr(str, idx+1, key);
    }
    public static void main(String[] args) {
        String str = "bcadeabdab";
        findOccr(str, 0, 'a');
    }
}