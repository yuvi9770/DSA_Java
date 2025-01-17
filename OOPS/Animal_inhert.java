package OOPS;

public class Animal_inhert {
    public static void main(String[] args) {
        Fish Whale = new Fish();
        Whale.eat();
    }
}

// base class
class Animals{
    String color;

    void eat(){
        System.out.println("Eats food ");
    }

    void breathe(){
        System.out.println("Breath");
    }
}

// Derived class
class Fish extends Animals{
    int fins;
    void swim(){
        System.out.println("Swims in waterr");
    }
}