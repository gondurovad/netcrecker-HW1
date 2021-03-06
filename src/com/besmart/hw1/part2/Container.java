package com.besmart.hw1.part2;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y - height;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public boolean collides(Ball ball) {
        float x = ball.getX();
        float y = ball.getY();
        float radius = ball.getRadius();

        return (x+radius < x2) && (x-radius > x1) && (y-radius > y2) && (y+radius < y1);
    }

    @Override
    public String toString() {
        return "Container[("+x1+","+y1+"),("+x2+","+y2+")]";
    }
    
    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + x1;
        result = 31*result + x2;
        result = 31*result + y1;
        result = 31*result + y2;        

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Container container = (Container) obj;

        return this.x1 == container.getX1()
                && this.x2 == container.getX2()
                && this.y1 == container.getY1()
                && this.y2 == container.getY2();
    }
}
