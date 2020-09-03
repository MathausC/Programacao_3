package com.CC;

public class NumeroComplexo {
    private double real;
    private double imag;

    private void setReal(double real) {
        this.real = real;
    }
    public double getReal() {
        return this.real;
    }

    private void setImag(double imag) {
        this.imag = imag;
    }
    public double getImag() {
        return this.imag;
    }

    public NumeroComplexo(double real, double imag) {
        this.setReal(real);
        this.setImag(imag);
    }

    public boolean éIgual(NumeroComplexo obj) {
        return (this.getReal() == obj.getReal() && this.getImag() == obj.getImag());
    }

    public void soma(NumeroComplexo obj) {
        double a, b;
        String mensagem = "Soma = ";
        a = this.getReal() + obj.getReal();
        b = this.getImag() + obj.getImag();
        if(b < 0) {
            mensagem += a + " - " + b + "i.";
        }
        else if(b == 0) {
            mensagem += a;
        }
        else {
            mensagem += a + " + " + b + "i.";
        }
        System.out.println(mensagem);
    }

    public void multiplica(NumeroComplexo obj) {
        double a, b;
        String mensagem = "Produto = ";
        a = (this.getReal() * obj.getReal()) - (this.getImag() * obj.getImag());
        b = (this.getReal() * obj.getImag()) + (this.getImag() * obj.getReal());
        if(b < 0) {
            mensagem += a + " - " + b + "i.";
        }
        else if(b == 0) {
            mensagem += a;
        }
        else {
            mensagem += a + " + " + b + "i.";
        }
        System.out.println(mensagem);
    }

    public void divide(NumeroComplexo obj) {
        double a, b, div;
        div = (Math.pow(obj.getReal(), 2)) + (Math.pow(obj.getImag(), 2));
        a = ((this.getReal() * obj.getReal()) + (this.getImag() * obj.getImag())) / div;
        b = ((this.getReal() * obj.getImag()) + (this.getImag() * obj.getReal())) / div;
        String mensagem = "Quociente = ";
        if(div != 0) {
            if(b < 0) {
                mensagem += a + " - " + b + "i.";
            }
            else if(b == 0) {
                mensagem += a;
            }
            else {
                mensagem += a + " + " + b + "i.";
            }
        }
        else {
            mensagem = "Resultado indeterminado.";
        }
        System.out.println(mensagem);
    }
}
