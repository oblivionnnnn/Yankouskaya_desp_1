package service.validator;

// service/validator/TriangleValidator.java
import java.util.List;

import entity.Point;
import entity.Triangle;
import exception.InvalidShapeException;

public class TriangleValidator implements ShapeValidator {
    @Override
    public void validate(Triangle triangle) throws InvalidShapeException {
        List<Point> points = triangle.getPoints();
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);

        // Check if points are collinear
        double area = Math.abs((a.getX()*(b.getY()-c.getY()) +
                b.getX()*(c.getY()-a.getY()) +
                c.getX()*(a.getY()-b.getY())) / 2);

        if (area < 0.0001) {
            throw new InvalidShapeException("Points are collinear - cannot form a triangle");
        }
    }
}