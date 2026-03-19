package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    @DisplayName("Факториал 3 равен 6")
    public void testFactorialOne() {
        assertEquals(6, Factorial.calculate(3));
    }

    @Test
    @DisplayName("Факториал 10 равен 3628800")
    public void testFactorialTen() {
        assertEquals(3628800, Factorial.calculate(10));
    }

    @Test
    @DisplayName("Факториал отрицательного числа выбрасывает исключение")
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-5);
        });
    }
}
