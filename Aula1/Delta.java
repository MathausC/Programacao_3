package Programacao_3;

public class Delta {
    private double a;
    private double b;
    private double c;

    private void setA(double a) {
        this.a = a;
    }
    private void setB(double b) {
        this.b = b;
    }
    private void setC(double c) {
        this.c = c;
    }
    public Delta(double a, double b, double c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    public double calcularDelta() {
        return (Math.pow(b, 2) - (4 * a * c));
    }
}
