package entity;
// entity/Triangle.java

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triangle {
    private String id;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(String id, Point pointA, Point pointB, Point pointC) {
        this.id = id;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public String getId() {
        return id;
    }

    public List<Point> getPoints() {
        return Arrays.asList(pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "Triangle " + id + " [A=" + pointA + ", B=" + pointB + ", C=" + pointC + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(id, triangle.id) &&
                Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointA, pointB, pointC);
    }
}