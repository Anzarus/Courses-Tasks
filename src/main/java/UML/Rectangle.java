package UML;

public class Rectangle {
    private double length = 1.0;
    private double width = 1.0;
    private String color = "red";

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return this.width;
    }

    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    public double getArea() {
        return this.length * this.width;
    }
}
