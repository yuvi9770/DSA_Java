package OOPS;

public class Abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        // Animal -> Horse 
        h.eats();
        h.walk();
        System.out.println(h.color);
    }
}

abstract class Animal2{
    String color;
    Animal2(){
        System.out.println("Animal Class constructor called...");
        color = "Brown";
    }

    void eats(){
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse extends Animal2 {
    Horse(){
        System.out.println("Horse Class constructor called...");
    }

    void ChangeColor(){
        color = "Black";
    }
    
    void walk(){
        System.out.println("Walk on 2 legs");
    }
}