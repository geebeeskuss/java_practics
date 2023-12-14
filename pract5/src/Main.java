abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        // Используем полупериметр и формулу Герона для вычисления площади треугольника
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Периметр круга: " + circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle.calculatePerimeter());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
        System.out.println("Периметр треугольника: " + triangle.calculatePerimeter());
    }
}
