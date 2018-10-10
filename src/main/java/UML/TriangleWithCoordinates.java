package UML;

public class TriangleWithCoordinates {
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pointOne = new Point(x1, y1);
        this.pointTwo = new Point(x2, y2);
        this.pointThree = new Point(x3, y3);
    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
    }

    public double getPerimeter() {
        double a = Math.sqrt(Math.pow((this.pointOne.getX() - this.pointTwo.getX()), 2) + Math.pow((this.pointOne.getY() - this.pointTwo.getY()), 2));
        double b = Math.sqrt(Math.pow((this.pointTwo.getX() - this.pointThree.getX()), 2) + Math.pow((this.pointTwo.getY() - this.pointThree.getY()), 2));
        double c = Math.sqrt(Math.pow((this.pointThree.getX() - this.pointOne.getX()), 2) + Math.pow((this.pointThree.getY() - this.pointOne.getY()), 2));
        return a + b + c;
    }

    public double getArea() {
        double a = Math.sqrt(Math.pow((this.pointOne.getX() - this.pointTwo.getX()), 2) + Math.pow((this.pointOne.getY() - this.pointTwo.getY()), 2));
        double b = Math.sqrt(Math.pow((this.pointTwo.getX() - this.pointThree.getX()), 2) + Math.pow((this.pointTwo.getY() - this.pointThree.getY()), 2));
        double c = Math.sqrt(Math.pow((this.pointThree.getX() - this.pointOne.getX()), 2) + Math.pow((this.pointThree.getY() - this.pointOne.getY()), 2));
        double perimeter = a + b + c;
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    public String getType() {
        return "";
    }

    public double distance(TriangleWithCoordinates other) {
        double thisCenterX = 1 / 3 * ((this.pointOne.getX() - this.pointTwo.getX())
                                        + (this.pointTwo.getX() - this.pointThree.getX())
                                        + (this.pointThree.getX() - this.pointOne.getX()));
        double thisCenterY = 1 / 3 * ((this.pointOne.getY() - this.pointTwo.getY())
                                        + (this.pointTwo.getY() - this.pointThree.getY())
                                        + (this.pointThree.getY() - this.pointOne.getY()));


        double otherCenterX = 1 / 3 * ((other.pointOne.getX() - other.pointTwo.getX())
                                        + (other.pointTwo.getX() - other.pointThree.getX())
                                        + (other.pointThree.getX() - other.pointOne.getX()));
        double otherCenterY = 1 / 3 * ((other.pointOne.getY() - other.pointTwo.getY())
                                        + (other.pointTwo.getY() - other.pointThree.getY())
                                        + (other.pointThree.getY() - other.pointOne.getY()));

        return Math.sqrt(Math.pow((thisCenterX - otherCenterX), 2) + Math.pow((thisCenterY - otherCenterY), 2));
    }
}
