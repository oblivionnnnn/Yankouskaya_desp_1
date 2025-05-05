// service/TriangleCalculator.java
package service;

import entity.Point;
import entity.Triangle;
import java.util.List;

public class TriangleCalculator implements CalculatorService {
    @Override
    public double calculatePerimeter(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double ab = distance(points.get(0), points.get(1));
        double bc = distance(points.get(1), points.get(2));
        double ca = distance(points.get(2), points.get(0));
        return ab + bc + ca;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);

        return Math.abs((a.getX()*(b.getY()-c.getY()) +
                b.getX()*(c.getY()-a.getY()) +
                c.getX()*(a.getY()-b.getY())) / 2);
    }

    // Changed from private to public
    public double distance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
}