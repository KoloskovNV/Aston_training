package Lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    @DisplayName("Факториал 3 равен 6")
    public void testFactorialThree() {
        assertEquals(Factorial.calculate(3), 6);
    }

    @Test
    @DisplayName("Факториал 10 равен 3628800")
    public void testFactorialTen() {
        assertEquals(Factorial.calculate(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @DisplayName("Факториал отрицательного числа выбрасывает исключение")
    public void testFactorialNegative() {
        Factorial.calculate(-5);
    }
}