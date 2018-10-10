package UML;

public class CircleWithCoordinates extends Circle{
    private double radius = 1.0;
    private Point center;
    private String color = "red";

    public CircleWithCoordinates(Point center){
        this.center = new Point();
    }
    public CircleWithCoordinates(Point center, double radius){
        this.center = new Point();
        this.radius = radius;
    }
    public CircleWithCoordinates(Point center, double radius, String color){
        this.center = new Point();
        this.radius = radius;
        this.color = color;
    }

//    @Override
//    public double getArea() {
//        return super.getArea();
//    }

    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getRadius() {
        return this.radius;
    }
    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        return super.getCircumference();
    }

    public void setCenter(Point center) {
        this.center = center;
    }
    public Point getCenter() {
        return this.center;
    }

    public double distance(Point other){
        return Math.sqrt(Math.pow((this.center.getX()-other.getX()),2) + Math.pow((this.center.getY()-other.getY()),2));
    }
}
