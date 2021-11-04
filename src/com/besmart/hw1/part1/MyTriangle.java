package com.besmart.hw1.part1;

import static java.lang.Double.compare;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        if (isCorrectTriangle(v1, v2, v3)==false)
            throw new IllegalArgumentException("these points can't form a triangle");
        else {
            this.v1 = new MyPoint(v1.getX(), v1.getY());
            this.v2 = new MyPoint(v2.getX(), v2.getY());
            this.v3 = new MyPoint(v3.getX(), v3.getY());
        }
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        MyPoint v1 = new MyPoint(x1, y1);
        MyPoint v2 = new MyPoint(x2, y2);
        MyPoint v3 = new MyPoint(x3, y3);

        if (isCorrectTriangle(v1, v2, v3)==false)
            throw new IllegalArgumentException("these points can't form a triangle");
        else {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
        }
    }

    public static boolean isCorrectTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        return (v1.distance(v2) + v1.distance(v3) > v2.distance(v3)
                && v1.distance(v2) + v2.distance(v3) > v1.distance(v3)
                && v1.distance(v3) + v2.distance(v3) > v1.distance(v2));
    }

    @Override
    public String toString() {
        return "MyTriangle[v1="+v1+", v2="+v2+", v3="+v3+"]";
    }


    public TriangleType getType() {
        double v12 = v1.distance(v2);
        double v13 = v1.distance(v3);
        double v23 = v2.distance(v3);

        if (compare(v12, v13) + compare(v12, v23) == 0) return TriangleType.Equilateral;
        else if ((compare(v12, v13) == 0)|| (compare(v12, v23) == 0) || (compare(v13, v23) == 0)) return TriangleType.Isosceles;
        else return TriangleType.Scalene;
    }
    
    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + v1.hashCode();
        result = 31*result + v2.hashCode();
        result = 31*result + v3.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        MyTriangle triangle = (MyTriangle) obj;

        return this.v1.equals(triangle.v1)
                && this.v2.equals(triangle.v2)
                && this.v3.equals(triangle.v3);
    }
}
