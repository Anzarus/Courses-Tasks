package UML;

public class Point {
    private double x = 1.0;
    private double y = 1.0;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public Circle(double radius, String color){
//
//    }

    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return this.y;
    }

    public double distance (double x, double y){
        return Math.sqrt(Math.pow((this.x-x),2) + Math.pow((this.y-y),2));
    }
    public double distance (Point other){
        return Math.sqrt(Math.pow((this.x-other.x),2) + Math.pow((this.y-other.y),2));
    }
}
