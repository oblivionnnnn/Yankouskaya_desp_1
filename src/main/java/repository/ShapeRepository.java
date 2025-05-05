package repository;

// repository/ShapeRepository.java

//import java.util.Collectors;
import entity.Triangle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ShapeRepository {
    private final List<Triangle> triangles = new ArrayList<>();

    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    public List<Triangle> query(Predicate<Triangle> specification) {
        return triangles.stream()
                .filter(specification)
                .collect(Collectors.toList());
    }

    public List<Triangle> getAll() {
        return new ArrayList<>(triangles);
    }

    public void sort(Comparator<Triangle> comparator) {
        triangles.sort(comparator);
    }
}