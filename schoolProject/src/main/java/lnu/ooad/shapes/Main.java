package lnu.ooad.shapes;

public class Main {

    public static void main(String[] args) {

        RegPolygonFactory regPolygonFactory = new RegPolygonFactory();
        final IRegularPolygon square = regPolygonFactory.getShape("SQUARE".toUpperCase(), 6);
        final IRegularPolygon eTriangle = regPolygonFactory.getShape("EQUILATERAL-TRIANGLE".toUpperCase(), 4);
        System.out.println(square.toString());
        System.out.println(eTriangle.toString());

    }
}
