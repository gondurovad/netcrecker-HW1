package com.besmart.hw1.part1;

public class MyPoint {
    private double x=0;
    private double y=0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getXY() {
        double[] xy = new double[2];
        xy[0]=x;
        xy[1]=y;
        return xy;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public double distance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public double distance(MyPoint anotherPoint) {
        double dx = this.x - anotherPoint.getX();
        double dy = this.y - anotherPoint.getY();
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public double distance() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        long tmp = Double.doubleToLongBits(x);
        long tmp2 = Double.doubleToLongBits(y);

        result = 31*result + (int)(tmp ^ (tmp >>> 32));
        result = 31*result + (int)(tmp2 ^ (tmp2 >>> 32));

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        MyPoint point = (MyPoint) obj;

        return Double.compare(this.x, point.getX())==0
                && Double.compare(this.y, point.getY())==0;
    }
}

