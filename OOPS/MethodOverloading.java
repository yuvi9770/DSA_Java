package OOPS;

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.sum(5, 6));
        System.out.println(cal.sum((float)5.5,(float) 16.8));
        System.out.println(cal.sum(5, 6,8));
    }
}

class Calculator{
    int sum(int a, int b){
        return a+b;
    }

    int sum(int a, int b, int c){
        return a+b;
    }

    float sum(float a, float b){
        return a+b;
    }
}