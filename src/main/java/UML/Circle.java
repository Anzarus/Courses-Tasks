package UML;

public class Circle extends Shape{
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

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }

    public double getCircumference() {
        return 2 * this.radius * 3.14;
    }
}