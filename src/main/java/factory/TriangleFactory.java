// factory/TriangleFactory.java
package factory;

import entity.Point;
import entity.Triangle;
import exception.InvalidShapeException;
import service.validator.TriangleValidator;

public class TriangleFactory implements ShapeFactory {
    private final TriangleValidator validator = new TriangleValidator();

    @Override
    public Triangle createTriangle(String id, String[] parameters) throws InvalidShapeException {
        if (parameters == null || parameters.length != 6) {
            throw new InvalidShapeException("Invalid number of parameters for triangle. Expected 6 coordinates.");
        }

        try {
            Point a = new Point(Double.parseDouble(parameters[0]), Double.parseDouble(parameters[1]));
            Point b = new Point(Double.parseDouble(parameters[2]), Double.parseDouble(parameters[3]));
            Point c = new Point(Double.parseDouble(parameters[4]), Double.parseDouble(parameters[5]));

            Triangle triangle = new Triangle(id, a, b, c);
            validator.validate(triangle);
            return triangle;
        } catch (NumberFormatException e) {
            throw new InvalidShapeException("Invalid point coordinates format: " + e.getMessage());
        } catch (NullPointerException e) {
            throw new InvalidShapeException("Parameters array contains null values");
        }
    }
}