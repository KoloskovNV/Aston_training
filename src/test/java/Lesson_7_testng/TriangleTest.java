package Lesson_7_testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {
    private final Triangle triangle = new Triangle();

    @Test(description = "Площадь треугольника с основанием 5 и высотой 6 равна 15")
    public void testAreaNormal() {
        assertEquals(triangle.area(5.0, 6.0), 15.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Основание <= 0 выбрасывает исключение")
    public void testAreaNegativeBase() {
        triangle.area(-5.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Высота <= 0 выбрасывает исключение")
    public void testAreaNegativeHeight() {
        triangle.area(5.0, -4.0);
    }
}