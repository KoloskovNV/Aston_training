package Lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

    @Test
    @DisplayName("Площадь треугольника с основанием 5 и высотой 6 равна 15")
    public void testAreaNormal() {
        assertEquals(Triangle.area(5.0, 6.0), 15.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @DisplayName("Основание <= 0 выбрасывает исключение")
    public void testAreaNegativeBase() {
        Triangle.area(-5.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @DisplayName("Высота <= 0 выбрасывает исключение")
    public void testAreaNegativeHeight() {
        Triangle.area(5.0, -4.0);
    }
}