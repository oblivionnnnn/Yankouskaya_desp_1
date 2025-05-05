package observer;

// observer/ShapeObserver.java

import entity.Triangle;
import service.CalculatorService;
import service.TriangleCalculator;

public class ShapeObserver {
    private final CalculatorService calculator = new TriangleCalculator();
    private final Warehouse warehouse = Warehouse.getInstance();

    public void update(Triangle triangle) {
        double perimeter = calculator.calculatePerimeter(triangle);
        double area = calculator.calculateArea(triangle);

        warehouse.updatePerimeter(triangle.getId(), perimeter);
        warehouse.updateArea(triangle.getId(), area);
    }
}
