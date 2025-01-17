package OOPS;

class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    {
        System.out.println("Instance initializer block in Child");
    }
    
    Child() {
        super(); // Calls Parent's constructor first
        System.out.println("Child constructor");
        
    }
}

public class Main {
    public static void main(String[] args) {
    new Child();
    }
}