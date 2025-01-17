package OOPS;

public class BlueCar extends Car {

    {
        System.out.print("4");
    }

    // when the sub class has a super method then it will execute first then Instance Initializer Block
    public BlueCar() {
        super("blue");
        System.out.print("5");
        
    }

    public static void main(String[] gears) {
        new BlueCar();
    }
}


abstract class Car {
    static {
        System.out.print("1");
    }

    public Car(String name) {
        super();
        System.out.print("2");
    }

    {
        System.out.print("3");
    }
}