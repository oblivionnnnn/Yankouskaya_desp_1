package com.geometry;


import entity.Triangle;
import factory.ShapeFactory;
import factory.TriangleFactory;
import repository.ShapeRepository;
import service.TriangleCalculator;
import service.TriangleStateService;
import util.FileReaderUtil;
import observer.ShapeObserver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Чтение треугольников из файла
        List<Triangle> triangles = FileReaderUtil.readTrianglesFromFile("src/main/resources/data/triangles.txt");

        // 2. Создание репозитория и добавление треугольников
        ShapeRepository repository = new ShapeRepository();
        triangles.forEach(repository::add);

        // 3. Создание сервисов
        TriangleCalculator calculator = new TriangleCalculator();
        TriangleStateService stateService = new TriangleStateService();
        ShapeObserver observer = new ShapeObserver();

        // 4. Обработка каждого треугольника
        for (Triangle triangle : repository.getAll()) {
            System.out.println("\nProcessing " + triangle.getId() + ": " + triangle);

            // Обновляем наблюдателя (Warehouse)
            observer.update(triangle);

            // Вычисляем параметры
            double perimeter = calculator.calculatePerimeter(triangle);
            double area = calculator.calculateArea(triangle);

            System.out.printf("Perimeter: %.2f\n", perimeter);
            System.out.printf("Area: %.2f\n", area);

            // Проверяем состояния
            System.out.println("Is right angled: " + stateService.isRightAngled(triangle));
            System.out.println("Is equilateral: " + stateService.isEquilateral(triangle));
            System.out.println("Is isosceles: " + stateService.isIsosceles(triangle));
            System.out.println("Is obtuse: " + stateService.isObtuse(triangle));
            System.out.println("Is acute: " + stateService.isAcute(triangle));
        }
    }
}