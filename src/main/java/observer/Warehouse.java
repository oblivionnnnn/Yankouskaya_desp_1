package observer;

// observer/Warehouse.java


import entity.Triangle;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private final Map<String, Double> perimeters = new HashMap<>();
    private final Map<String, Double> areas = new HashMap<>();

    private Warehouse() {}

    public static synchronized Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void updatePerimeter(String triangleId, double perimeter) {
        perimeters.put(triangleId, perimeter);
    }

    public void updateArea(String triangleId, double area) {
        areas.put(triangleId, area);
    }

    public Double getPerimeter(String triangleId) {
        return perimeters.get(triangleId);
    }

    public Double getArea(String triangleId) {
        return areas.get(triangleId);
    }
}