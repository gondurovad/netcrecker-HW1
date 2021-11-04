package com.besmart.hw1.part2;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        if (direction<-180 || direction>180)
            throw new IllegalArgumentException("direction must be in range [-180, 180]");
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float)(speed*Math.cos(Math.toRadians(direction)));
        this.yDelta = (float)((-1)*speed*Math.sin(Math.toRadians(direction)));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[("+x+","+y+"), speed=("+xDelta+","+yDelta+")]";
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        
        result = 31*result + Float.floatToIntBits(x);
        result = 31*result + Float.floatToIntBits(y);
        result = 31*result + radius;
        result = 31*result + Float.floatToIntBits(xDelta);
        result = 31*result + Float.floatToIntBits(yDelta);
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Ball ball = (Ball) obj;

        return this.x == ball.getX() 
                && this.y == ball.getY()
                && this.radius == ball.getRadius()
                && this.xDelta == ball.getXDelta()
                && this.yDelta == ball.getYDelta();
    }
}
