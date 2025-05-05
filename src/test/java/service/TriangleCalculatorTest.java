package service;

// test/service/TriangleCalculatorTest.java


import entity.Point;
import entity.Triangle;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleCalculatorTest {
    private static final Triangle RIGHT_TRIANGLE = new Triangle("1",
            new Point(0, 0), new Point(3, 0), new Point(0, 4));
    private static final Triangle EQUILATERAL_TRIANGLE = new Triangle("2",
            new Point(0, 0), new Point(2, 0), new Point(1, Math.sqrt(3)));
    private static final TriangleCalculator CALCULATOR = new TriangleCalculator();

    @Test
    public void testCalculatePerimeter() {
        double perimeter = CALCULATOR.calculatePerimeter(RIGHT_TRIANGLE);
        assertEquals(perimeter, 12.0, 0.0001);
    }

    @Test
    public void testCalculateArea() {
        double area = CALCULATOR.calculateArea(RIGHT_TRIANGLE);
        assertEquals(area, 6.0, 0.0001);
    }

    @Test
    public void testCalculateAreaEquilateral() {
        double area = CALCULATOR.calculateArea(EQUILATERAL_TRIANGLE);
        assertEquals(area, Math.sqrt(3), 0.0001);
    }
}