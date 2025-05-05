package factory;

// factory/ShapeFactory.java


import entity.Triangle;
import exception.InvalidShapeException;

public interface ShapeFactory {
    Triangle createTriangle(String id, String[] parameters) throws InvalidShapeException;
}
