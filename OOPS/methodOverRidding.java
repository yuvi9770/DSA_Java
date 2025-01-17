package OOPS;

public class methodOverRidding {
    public static void main(String[] args) {
        Deer d = new Deer();
        d.eats();
    }
}

class Animal{
    void eats(){
        System.out.println("Eats Anythig");
    }
}

class Deer extends Animal{
    @Override
    void eats(){
        System.out.println("Eats Grass");
    }
}