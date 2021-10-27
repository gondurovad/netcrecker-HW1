package com.besmart.hw1.part2;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        if (coeffs.length==0)
            throw new IllegalArgumentException("polynomial can't be empty");
        this.coeffs = new double[coeffs.length];
        for (int i=0; i<coeffs.length; i++)
            this.coeffs[i] = coeffs[i];
    }

    public int getDegree() {
        int degree = 0;
        for (int i = coeffs.length - 1; i >= 0; i--)
            if (coeffs[i] != 0) {
                degree = i;
                break;
            }
        return degree;
    }

    private String numberSign (double num) {
        return (num<0) ? "-" : "+";
    }

    @Override
    public String toString() {
        String polynomial = new String();
        int n = getDegree();
        polynomial += coeffs[n]+"x^"+n;
        for (int i = n-1; i > 0; i--)
            if (coeffs[i]!=0)
                polynomial += numberSign(coeffs[i])+Math.abs(coeffs[i])+"x^"+i;
        if (coeffs[0]!=0) polynomial+=numberSign(coeffs[0])+Math.abs(coeffs[0]);
        return polynomial;
    }

    public double evaluate(double x) {
        int n = getDegree();
        if (n==0) return coeffs[0];
        double res = coeffs[0];
        for (int i=1; i<=n; i++)
            res+=coeffs[i]*Math.pow(x, i);
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
         int maxDegree = (getDegree()>=right.getDegree()) ? getDegree() : right.getDegree();

         double[] resCoeffs = new double[maxDegree+1];
         for (int i=0; i<= getDegree(); i++)
             resCoeffs[i]+=coeffs[i];
         for (int i=0; i<= right.getDegree(); i++)
             resCoeffs[i]+=right.coeffs[i];

         return new MyPolynomial(resCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int resDegree = getDegree() + right.getDegree();
        double[] resCoeffs = new double[resDegree+1];

        for (int i=0; i<=getDegree(); i++)
            for (int j=0; j<= right.getDegree(); j++)
                resCoeffs[i+j]+=coeffs[i]*right.coeffs[j];

        return new MyPolynomial(resCoeffs);
    }
}
