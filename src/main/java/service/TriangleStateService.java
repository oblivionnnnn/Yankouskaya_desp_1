// service/TriangleStateService.java
package service;

import entity.Triangle;
import entity.Point;
import java.util.List;
import java.util.Arrays;

public class TriangleStateService {
    private final TriangleCalculator calculator = new TriangleCalculator();

    public boolean isRightAngled(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double a = calculator.distance(points.get(0), points.get(1));
        double b = calculator.distance(points.get(1), points.get(2));
        double c = calculator.distance(points.get(2), points.get(0));

        double[] sides = {a, b, c};
        Arrays.sort(sides);

        return Math.abs(sides[0]*sides[0] + sides[1]*sides[1] - sides[2]*sides[2]) < 0.0001;
    }

    public boolean isEquilateral(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double a = calculator.distance(points.get(0), points.get(1));
        double b = calculator.distance(points.get(1), points.get(2));
        double c = calculator.distance(points.get(2), points.get(0));

        return Math.abs(a - b) < 0.0001 && Math.abs(b - c) < 0.0001;
    }

    public boolean isIsosceles(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double a = calculator.distance(points.get(0), points.get(1));
        double b = calculator.distance(points.get(1), points.get(2));
        double c = calculator.distance(points.get(2), points.get(0));

        return Math.abs(a - b) < 0.0001 ||
                Math.abs(b - c) < 0.0001 ||
                Math.abs(c - a) < 0.0001;
    }

    public boolean isObtuse(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double a = calculator.distance(points.get(0), points.get(1));
        double b = calculator.distance(points.get(1), points.get(2));
        double c = calculator.distance(points.get(2), points.get(0));

        double[] sides = {a, b, c};
        Arrays.sort(sides);

        return sides[0]*sides[0] + sides[1]*sides[1] < sides[2]*sides[2];
    }

    public boolean isAcute(Triangle triangle) {
        List<Point> points = triangle.getPoints();
        double a = calculator.distance(points.get(0), points.get(1));
        double b = calculator.distance(points.get(1), points.get(2));
        double c = calculator.distance(points.get(2), points.get(0));

        double[] sides = {a, b, c};
        Arrays.sort(sides);

        return sides[0]*sides[0] + sides[1]*sides[1] > sides[2]*sides[2];
    }
}