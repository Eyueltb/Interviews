package lnu.ooad.shapes;

public class Square implements IRegularPolygon {

    private static final int NUMBER_OF_SIDES = 4;
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return NUMBER_OF_SIDES * sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Square{ " +
                "Area = " + getArea() +
                ", Perimeter = " + getPerimeter() +
                '}';
    }
}
