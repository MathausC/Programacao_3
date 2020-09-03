package Programacao_3;

public class Baskara {

    private Delta delta;
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

    public Baskara (double a, double b, double c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
        this.delta = new Delta(a, b, c);
    }

    public void exibirRaiz1() {
        if(delta.calcularDelta() < 0) {
            System.out.print("Raizes não existe.");
        }
        else {
            double raiz = (-b + Math.sqrt(delta.calcularDelta())) / (2 * a);
            System.out.println("A primeira raiz é " + raiz);
        }
    }

    public void exibirRaiz2() {
        if(delta.calcularDelta() >= 0) {
            double raiz = (-b - Math.sqrt(delta.calcularDelta())) / (2 * a);
            System.out.println("A segunda raiz é " + raiz);
        }
    }
}
