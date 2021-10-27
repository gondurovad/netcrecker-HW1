package com.besmart.hw1;

import com.besmart.hw1.part1.*;
import com.besmart.hw1.part2.*;

public class Main {

    public static void main(String args[]) {
        /*Первая часть работы*/
        //тестируем функциональность Circle
        Circle circle = new Circle(2.5, "green");
        System.out.println(circle);
        System.out.println("circle area: " + circle.calculateArea());
        System.out.println("--------------------");

        //тестируем функциональность Rectangle
        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println(rectangle);
        System.out.println("rectangle area: "+rectangle.calculateArea()+", perimeter: "+rectangle.calculatePerimeter());
        System.out.println("--------------------");

        //тестируем функциональность Employee
        Employee employee = new Employee(1013, "Dan", "Kim", 1235);
        System.out.println(employee);
        System.out.println("annual salary: "+employee.getAnnualSalary());
        System.out.println("increase the salary by the percent: 12%, new salary: "+employee.raiseSalary(12));
        System.out.println("--------------------");

        //тестируем функциональность Book
        Author[] authors = new Author[2];
        authors[0] = new Author("Strongina N.R.", "strongina@gmail.com", 'F');
        authors[1] = new Author("Balabanov A.S.", "balabanov@gmail.com", 'M');

        Book book = new Book("Data analysis in economics", authors, 1050, 5);
        System.out.println(book);
        System.out.println(book.getAuthorsNames());
        System.out.println("--------------------");

        //тестируем функциональность MyTriangle
        MyPoint point1 = new MyPoint(1, 0);
        MyPoint point2 = new MyPoint(5, 0);
        MyPoint point3 = new MyPoint(3, 4+2*Math.sqrt(3));

        MyTriangle triangle = new MyTriangle(point1, point2, point3);
        System.out.println(triangle);
        System.out.println(triangle.getType());
        System.out.println("--------------------");

        /*Вторая часть работы*/
        //Тестируем MyComplex
        MyComplex complex1 = new MyComplex(2, -3);
        MyComplex complex2 = new MyComplex(3, 0);

        System.out.println(complex1+", "+complex2);
        System.out.println(complex2.isImaginary()+" "+complex2.isReal());
        System.out.println("are equals? " + (complex1==complex2));
        System.out.println("|z1|="+complex1.magnitude()+", |z2|="+complex2.magnitude());
        System.out.println(complex2.argument());

        System.out.println(complex1.addNew(complex2));
        System.out.println(complex1);
        System.out.println(complex1.add(complex2));
        System.out.println(complex1);
        System.out.println(complex1.subtract(complex2));
        System.out.println(complex1);

        System.out.println(complex1.multiply(complex2));
        System.out.println(complex1);
        System.out.println(complex1.divide(complex2));
        System.out.println(complex1.conjugate());

        System.out.println(complex1.getReal()*complex1.getReal()+ complex1.getImag()*complex1.getImag());
        System.out.println(complex1.magnitude()*complex1.magnitude());

        System.out.println("--------------------");

        //Тестируем MyPolynomial

        MyPolynomial pol = new MyPolynomial(1, -2, 3, 0, 0);
        System.out.println(pol);
        System.out.println(pol.getDegree());
        System.out.println(pol.evaluate(1));

        MyPolynomial pol2 = new MyPolynomial(2, 2, 2, 2);
        System.out.println(pol2);

        System.out.println(pol.add(pol2));
        System.out.println(pol.multiply(pol2));

        System.out.println("--------------------");

        //Тестируем Ball: создаем контейнер, помещаем мяч в центр, перемещаем за границы контейнера
        Container container = new Container(2, 9, 8, 6);
        Ball ball = new Ball(6,6,1, 8, 0);

        System.out.println(container);
        System.out.println(ball);
        System.out.println(container.collides(ball));

        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));

        ball.setXDelta(-6);
        ball.setYDelta(1);
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));

        ball.reflectVertical();
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
    }
}