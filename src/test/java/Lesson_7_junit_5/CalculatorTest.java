package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-5, 0, -5"})
    @DisplayName("Сложение")
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "-5, 0, -5"})
    @DisplayName("Вычитание")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50",
            "-5, 0, 0"})
    @DisplayName("Умножение")
    public void testMultiply(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 2",
            "-5, 1, -5"})
    @DisplayName("Деление")
    public void testDivide(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @Test
    @DisplayName("Деление на 0 выбрасывает исключение")
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->
            calculator.divide(10, 0));
    }
}