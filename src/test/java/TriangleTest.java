// test/entity/TriangleTest.java

import entity.Point;
import entity.Triangle;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.List;

public class TriangleTest {
    private static final Point POINT_A = new Point(0, 0);
    private static final Point POINT_B = new Point(3, 0);
    private static final Point POINT_C = new Point(0, 4);
    private static final Triangle TRIANGLE = new Triangle("1", POINT_A, POINT_B, POINT_C);

    @Test
    public void testGetPoints() {
        List<Point> points = TRIANGLE.getPoints();
        assertEquals(points.size(), 3);
        assertTrue(points.contains(POINT_A));
        assertTrue(points.contains(POINT_B));
        assertTrue(points.contains(POINT_C));
    }

    @Test
    public void testEquals() {
        Triangle sameTriangle = new Triangle("1", new Point(0, 0), new Point(3, 0), new Point(0, 4));
        Triangle differentTriangle = new Triangle("2", new Point(0, 0), new Point(1, 0), new Point(0, 1));

        assertEquals(TRIANGLE, sameTriangle);
        assertNotEquals(TRIANGLE, differentTriangle);
    }

    @Test
    public void testHashCode() {
        Triangle sameTriangle = new Triangle("1", new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertEquals(TRIANGLE.hashCode(), sameTriangle.hashCode());
    }
}