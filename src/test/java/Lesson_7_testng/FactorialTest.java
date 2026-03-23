package Lesson_7_testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {
    private final Factorial factorial = new Factorial();

    @Test(description = "Факториал 3 равен 6")
    public void testFactorialThree() {
        assertEquals(factorial.calculate(3), 6);
    }

    @Test(description = "Факториал 10 равен 3628800")
    public void testFactorialTen() {
        assertEquals(factorial.calculate(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Факториал отрицательного числа выбрасывает исключение")
    public void testFactorialNegative() {
        factorial.calculate(-5);
    }
}