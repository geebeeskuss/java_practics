abstract class Movable {
    abstract void moveUp();

    abstract void moveDown();

    abstract void moveLeft();

    abstract void moveRight();
}

class MovableCircle extends Movable {
    private MovablePoint center;
    private int radius;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public void moveUp() {
        this.center.moveUp();
    }

    public void moveDown() {
        this.center.moveDown();
    }

    public void moveLeft() {
        this.center.moveLeft();
    }

    public void moveRight() {
        this.center.moveRight();
    }

    public String toString() {
        String var10000 = this.center.toString();
        return "Center: " + var10000 + ", Radius: " + this.radius;
    }
}

class MovablePoint extends Movable {
    private int x;
    private int y;
    protected int xSpeed;
    protected int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void moveUp() {
        this.y -= this.ySpeed;
    }

    public void moveDown() {
        this.y += this.ySpeed;
    }

    public void moveLeft() {
        this.x -= this.xSpeed;
    }

    public void moveRight() {
        this.x += this.xSpeed;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

class MovableRectangle extends Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public void moveUp() {
        this.topLeft.moveUp();
        this.bottomRight.moveUp();
    }

    public void moveDown() {
        this.topLeft.moveDown();
        this.bottomRight.moveDown();
    }

    public void moveLeft() {
        this.topLeft.moveLeft();
        this.bottomRight.moveLeft();
    }

    public void moveRight() {
        this.topLeft.moveRight();
        this.bottomRight.moveRight();
    }

    public boolean hasSameSpeed() {
        return this.topLeft.xSpeed == this.bottomRight.xSpeed && this.topLeft.ySpeed == this.bottomRight.ySpeed;
    }

    public String toString() {
        String var10000 = this.topLeft.toString();
        return "Top Left: " + var10000 + ", Bottom Right: " + this.bottomRight.toString();
    }
}

public class MovableTest {
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(1, 2, 4, 6, 2, 2);
        System.out.println("Original Rectangle:");
        System.out.println(rectangle);
        rectangle.moveUp();
        System.out.println("\nRectangle after moving up:");
        System.out.println(rectangle);
        rectangle.moveRight();
        System.out.println("\nRectangle after moving right:");
        System.out.println(rectangle);
        System.out.println("\nDoes the rectangle have the same speed for both points? " + rectangle.hasSameSpeed());
        MovableCircle circle = new MovableCircle(2, 3, 1, 1, 5);
        System.out.println("Original Circle:");
        System.out.println(circle);
        circle.moveUp();
        System.out.println("\nCircle after moving up:");
        System.out.println(circle);
        circle.moveRight();
        System.out.println("\nCircle after moving right:");
        System.out.println(circle);

        // Test MovablePoint
        MovablePoint point = new MovablePoint(3, 4, 2, 2);
        System.out.println("\nOriginal Point:");
        System.out.println(point);
        point.moveDown();
        System.out.println("\nPoint after moving down:");
        System.out.println(point);
        point.moveLeft();
        System.out.println("\nPoint after moving left:");
        System.out.println(point);
    }
}
