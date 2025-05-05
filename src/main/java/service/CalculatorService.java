package service;

// service/CalculatorService.java

import entity.Triangle;

public interface CalculatorService {
    double calculatePerimeter(Triangle triangle);
    double calculateArea(Triangle triangle);
}