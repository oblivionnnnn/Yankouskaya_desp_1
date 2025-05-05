package service.validator;

// service/validator/ShapeValidator.java


import entity.Triangle;
import exception.InvalidShapeException;

public interface ShapeValidator {
    void validate(Triangle triangle) throws InvalidShapeException;
}