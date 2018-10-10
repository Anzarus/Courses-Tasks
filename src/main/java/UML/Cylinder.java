package UML;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(double radius) {
        this.setRadius(radius);
    }

    public Cylinder(double radius, String color) {
        this.setRadius(radius);
        this.setColor(color);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

//    public double getVolume() {
//        return getArea() * getHeight();
//    }
}