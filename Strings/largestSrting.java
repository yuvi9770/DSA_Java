package Strings;

public class largestSrting {
    public static void largest(String fruit[]){
        String large = fruit[0];
        for (int i = 1; i < fruit.length; i++) {
            if (large.compareTo(fruit[i]) < 0) {
                large = fruit[i];
            }
        }
        System.out.println(large);

    }
    public static void main(String[] args) {
        String fruit[] = {"apple", "mango", "banana"};
        largest(fruit);
    }
}