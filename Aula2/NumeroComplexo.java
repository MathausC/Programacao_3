package Aula1;

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

    public NumeroComplexo soma(NumeroComplexo obj) {
        double a, b;
        a = this.getReal() + obj.getReal();
        b = this.getImag() + obj.getImag();
        return new NumeroComplexo(a, b);
    }
    
    public NumeroComplexo subitrai(NumeroComplexo obj) {
    	double a, b;
    	a = this.getReal() - obj.getReal();
    	b = this.getImag() - obj.getImag();
    	return new NumeroComplexo(a, b);
    }

    public NumeroComplexo multiplica(NumeroComplexo obj) {
        double a, b;
        a = (this.getReal() * obj.getReal()) - (this.getImag() * obj.getImag());
        b = (this.getReal() * obj.getImag()) + (this.getImag() * obj.getReal());
        return new NumeroComplexo(a, b);
    }

    public NumeroComplexo divide(NumeroComplexo obj) {
        double a, b, div;
        div = (Math.pow(obj.getReal(), 2)) + (Math.pow(obj.getImag(), 2));
        a = ((this.getReal() * obj.getReal()) + (this.getImag() * obj.getImag())) / div;
        b = ((this.getReal() * obj.getImag()) + (this.getImag() * obj.getReal())) / div;
        return new NumeroComplexo(a, b);
    }
    
    public String toString() {
    	String mensagem = this.real + " + " + this.imag + "i";
    	return mensagem;
    }
}
