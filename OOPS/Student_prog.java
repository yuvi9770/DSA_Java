package OOPS;

public class Student_prog {
    public static void main(String[] args) {
        Studentz s1 = new Studentz("Hello");
        System.out.println(s1.name);
    }
}

class Studentz{
    String name;
    int roll;

    Studentz(String name){
        this.name = name;
    }
}