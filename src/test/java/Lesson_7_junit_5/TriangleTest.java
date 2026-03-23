package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private final Triangle triangle = new Triangle();

    @Test
    @DisplayName("Площадь треугольника с основанием 5 и высотой 6 равна 15")
    public void testAreaNormal() {
        assertEquals(15.0, triangle.area(5.0, 6.0));
    }

    @Test
    @DisplayName("Основание <= 0 выбрасывает исключение")
    public void testAreaNegativeBase() {
        assertThrows(IllegalArgumentException.class, () ->
            triangle.area(-5.0, 4.0));
    }

    @Test
    @DisplayName("Высота <= 0 выбрасывает исключение")
    public void testAreaNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () ->
            triangle.area(5.0, 0.0));
    }
}