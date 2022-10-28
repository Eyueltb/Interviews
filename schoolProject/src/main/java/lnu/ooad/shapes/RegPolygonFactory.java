package lnu.ooad.shapes;

/**
 * Create instance of an object
 */
public class RegPolygonFactory {

    public IRegularPolygon getShape(String shapeType, double sideLength) {
        return switch (shapeType) {
            case "SQUARE" -> new Square(sideLength);
            case "EQUILATERAL-TRIANGLE" -> new EquilateralTriangle(sideLength);
            default -> throw new UnsupportedOperationException();
        };
    }
}
