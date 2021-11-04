package com.besmart.hw1.part1;

public class Rectangle {
    private float length;
    private float width;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double calculateArea() {
        return length*width;
    }

    public double calculatePerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "Rectangle[length="+length+", width="+width+"]";
    }
    
    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + Float.floatToIntBits(length);
        result = 31*result + Float.floatToIntBits(width);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Rectangle rect = (Rectangle) obj;

        return this.length == rect.getLength() && this.width == rect.getWidth();
    }
}
