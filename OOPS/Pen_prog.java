package OOPS;

public class Pen_prog {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.SetColor("Blue");
        System.out.println(p1.color);
        p1.SetTip(3);
        System.out.println(p1.Tip);
        p1.color = "Yellow";
        System.out.println(p1.color);
    }
}

class Pen{
    String color;
    int Tip;

    void SetColor(String color){
        this.color = color;
    }

    void SetTip(int Tip){
        this.Tip = Tip;
    }
}