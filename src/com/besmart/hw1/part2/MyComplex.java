package com.besmart.hw1.part2;

import static java.lang.Double.compare;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    private String numberSign (double num) {
        return (num<0) ? "-" : "+";
    }

    @Override
    public String toString() {
        if (imag==0) return real+"";
        else return real+numberSign(imag)+Math.abs(imag)+"i";
    }

    public boolean isReal() {
        return imag==0;
    }

    public boolean isImaginary() {
        return real==0 & imag!=0;
    }

    public boolean equals(double real, double imag) {
        return (compare(this.real, real)==0) & (compare(this.imag, imag)==0);
    }

    public boolean equals(MyComplex another) {
        return (compare(this.real, another.getReal())==0) & (compare(this.imag, another.getImag())==0);
    }

    public double magnitude() {
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument() {
        if (real==0 & imag==0)
            throw new IllegalArgumentException("argument of z=0 is undefined");
        return Math.atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        this.setReal(real+ right.getReal());
        this.setImag(imag+ right.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real+right.getReal(), imag+ right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        this.setReal(real- right.getReal());
        this.setImag(imag- right.getImag());
        return this;
    }

    public MyComplex subtractNew (MyComplex right) {
        return new MyComplex(real-right.getReal(), imag-right.getImag());
    }

    public MyComplex multiply (MyComplex right) {
        double realRight = right.getReal();
        double imagRight = right.getImag();

        double re = real*realRight - imag*imagRight;
        double im = real*imagRight + imag*realRight;

        this.setValue(re, im);
        return this;
    }

    public MyComplex divide (MyComplex right) {
        if(right.magnitude() == 0)
            throw new ArithmeticException("division on zero");

        double realRight = right.getReal();
        double imagRight = right.getImag();

        double re = ((real*realRight + imag*imagRight)/Math.pow(right.magnitude(), 2));
        double im = (imag*realRight - real*imagRight)/Math.pow(right.magnitude(), 2);

        this.setValue(re, im);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }
}
