abstract class MyShape {
    protected String myColor;
    protected boolean myFilled;

    public MyShape() {
        this.myColor = "unknown";
        this.myFilled = false;
    }

    public MyShape(String myColor, boolean myFilled) {
        this.myColor = myColor;
        this.myFilled = myFilled;
    }

    public String getMyColor() {
        return myColor;
    }

    public void setMyColor(String myColor) {
        this.myColor = myColor;
    }

    public boolean isMyFilled() {
        return myFilled;
    }

    public void setMyFilled(boolean myFilled) {
        this.myFilled = myFilled;
    }

    public abstract double getMyArea();
    public abstract double getMyPerimeter();

    @Override
    public String toString() {
        return "MyShape[myColor=" + myColor + ", myFilled=" + myFilled + "]";
    }
}

class MyCircle extends MyShape {
    protected double myRadius;

    public MyCircle() {
        this.myRadius = 1.0;
    }

    public MyCircle(double myRadius) {
        this.myRadius = myRadius;
    }

    public MyCircle(double myRadius, String myColor, boolean myFilled) {
        super(myColor, myFilled);
        this.myRadius = myRadius;
    }

    public double getMyRadius() {
        return myRadius;
    }

    public void setMyRadius(double myRadius) {
        this.myRadius = myRadius;
    }

    @Override
    public double getMyArea() {
        return Math.PI * myRadius * myRadius;
    }

    @Override
    public double getMyPerimeter() {
        return 2 * Math.PI * myRadius;
    }

    @Override
    public String toString() {
        return "MyCircle[" + super.toString() + ", myRadius=" + myRadius + "]";
    }
}

class MyRectangle extends MyShape {
    protected double myWidth;
    protected double myLength;

    public MyRectangle() {
        this.myWidth = 1.0;
        this.myLength = 1.0;
    }

    public MyRectangle(double myWidth, double myLength) {
        this.myWidth = myWidth;
        this.myLength = myLength;
    }

    public MyRectangle(double myWidth, double myLength, String myColor, boolean myFilled) {
        super(myColor, myFilled);
        this.myWidth = myWidth;
        this.myLength = myLength;
    }

    public double getMyWidth() {
        return myWidth;
    }

    public void setMyWidth(double myWidth) {
        this.myWidth = myWidth;
    }

    public double getMyLength() {
        return myLength;
    }

    public void setMyLength(double myLength) {
        this.myLength = myLength;
    }

    @Override
    public double getMyArea() {
        return myWidth * myLength;
    }

    @Override
    public double getMyPerimeter() {
        return 2 * (myWidth + myLength);
    }

    @Override
    public String toString() {
        return "MyRectangle[" + super.toString() + ", myWidth=" + myWidth + ", myLength=" + myLength + "]";
    }
}

class MySquare extends MyRectangle {
    public MySquare() {
        super();
    }

    public MySquare(double mySide) {
        super(mySide, mySide);
    }

    public MySquare(double mySide, String myColor, boolean myFilled) {
        super(mySide, mySide, myColor, myFilled);
    }

    public double getMySide() {
        return getMyWidth();  // Because width and length are the same for a square
    }

    public void setMySide(double mySide) {
        setMyWidth(mySide);
        setMyLength(mySide);
    }

    @Override
    public void setMyWidth(double mySide) {
        super.setMyWidth(mySide);
        super.setMyLength(mySide);
    }

    @Override
    public void setMyLength(double mySide) {
        super.setMyWidth(mySide);
        super.setMyLength(mySide);
    }

    @Override
    public String toString() {
        return "MySquare[" + super.toString() + ", mySide=" + getMySide() + "]";
    }
}

public class task2 {
    public static void main(String[] args) {
        MyCircle circle = new MyCircle(5.0, "red", true);
        System.out.println("MyCircle - " + circle);
        System.out.println("Area: " + circle.getMyArea());
        System.out.println("Perimeter: " + circle.getMyPerimeter());

        MyRectangle rectangle = new MyRectangle(4.0, 6.0, "blue", false);
        System.out.println("MyRectangle - " + rectangle);
        System.out.println("Area: " + rectangle.getMyArea());
        System.out.println("Perimeter: " + rectangle.getMyPerimeter());

        MySquare square = new MySquare(3.0, "green", true);
        System.out.println("MySquare - " + square);
        System.out.println("Area: " + square.getMyArea());
        System.out.println("Perimeter: " + square.getMyPerimeter());
    }
}

