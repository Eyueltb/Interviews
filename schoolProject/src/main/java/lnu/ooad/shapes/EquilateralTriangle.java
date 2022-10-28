package lnu.ooad.shapes;

public class EquilateralTriangle implements IRegularPolygon{

    private static final int NUMBER_OF_SIDES = 3;
    private double sideLength;

    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return NUMBER_OF_SIDES * sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength * Math.sqrt(3) / 4;
    }

    @Override
    public String toString() {
        return "EquilateralTriangle{ " +
                "Area = " + getArea() +
                ", Perimeter = " + getPerimeter() +
                '}';
    }
}
