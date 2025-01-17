package Recursion;

public class towerOfHanoi {
    public static void tower(int n, String src, String dest, String helper){
        if (n == 0) {
            // System.out.println("Disk transfer "+ n +" from " + src + " to " + dest);
            return;
        }
        tower(n-1, src, helper, dest);
        System.out.println("Disk transfer "+ n +" from " + src + " to " + dest);
        tower(n-1, helper, dest, src);
    }

    public static void main(String[] args) {
        int n = 3;
        tower(n, "S", "D", "H");
    }
}