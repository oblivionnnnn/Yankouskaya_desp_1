package util;

// util/FileReaderUtil.java


import factory.ShapeFactory;
import factory.TriangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import entity.Triangle;
import java.util.Arrays;
public class FileReaderUtil {
    private static final Logger logger = LogManager.getLogger(FileReaderUtil.class);
    private static final String DELIMITER = ";";

    public static List<Triangle> readTrianglesFromFile(String filePath) {
        List<entity.Triangle> triangles = new ArrayList<>();
        ShapeFactory factory = new TriangleFactory();

        try {
            Files.lines(Paths.get(filePath))
                    .forEach(line -> {
                        try {
                            String[] parts = line.split(DELIMITER);
                            if (parts.length < 7) {
                                logger.warn("Invalid line format: {}", line);
                                return;
                            }

                            String id = parts[0].trim();
                            String[] coordinates = Arrays.copyOfRange(parts, 1, parts.length);

                            Triangle triangle = factory.createTriangle(id, coordinates);
                            triangles.add(triangle);
                            logger.info("Successfully created triangle: {}", triangle);
                        } catch (Exception e) {
                            logger.error("Error processing line: {}. Error: {}", line, e.getMessage());
                        }
                    });
        } catch (IOException e) {
            logger.error("Error reading file: {}", e.getMessage());
        }

        return triangles;
    }
}
