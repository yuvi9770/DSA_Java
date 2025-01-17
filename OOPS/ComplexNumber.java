package OOPS;

public class ComplexNumber {
    public static void main(String[] args) {
        Complex c = new Complex(4,5);
        Complex d = new Complex(9,4);
    
        Complex e = Complex.Add(c, d);
        Complex f = Complex.Difference(c, d);
        Complex g = Complex.Product(c, d);
        e.printComplex();
        f.printComplex();
        g.printComplex();
    }
}


class Complex{
    int real;
    int imag;

    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public static Complex Add(Complex a, Complex b){
        return new Complex((a.real + b.real), (a.imag + b.imag));
    }
    
    public static Complex Difference(Complex a, Complex b){
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }
    
    public static Complex Product(Complex a, Complex b){
        return new Complex(((a.real * b.real) - (a.imag * b.imag)), ((a.real * b.imag) + (a.imag * b.real )));
    }


    public void printComplex(){
        if (real == 0 && imag == 0) {
            System.out.println("0");
        }else if (real != 0 && imag == 0 ) {
            System.out.println(real);
        }else if (real == 0 && imag != 0) {
            System.out.println(imag);
        }else{
            System.out.println(real + " + " + imag + "i");
        }
    }
}