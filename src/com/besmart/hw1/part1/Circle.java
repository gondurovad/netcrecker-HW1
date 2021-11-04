package com.besmart.hw1.part1;

import static java.lang.Math.pow;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[radius="+radius+", color="+color+"]";
    }

    public double calculateArea() {
        return Math.PI*pow(radius, 2);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        long tmp = Double.doubleToLongBits(radius);

        result = 31*result + (int)(tmp ^ (tmp >>> 32));
        result = 31*result + color.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Circle circle = (Circle)obj;

        return this.color.equals(circle.getColor())
                && Double.compare(this.radius, circle.getRadius())==0;
    }
}
