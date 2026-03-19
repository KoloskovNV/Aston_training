package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-5, 0, -5"})
    @DisplayName("Сложение")
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "-5, 0, -5"})
    @DisplayName("Вычитание")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(expected, Calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50",
            "-5, 0, 0"})
    @DisplayName("Умножение")
    public void testMultipl(int a, int b, int expected) {
        assertEquals(expected, Calculator.multipl(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 2",
            "-5, 1, -5"})
    @DisplayName("Деление")
    public void testDivisi(int a, int b, int expected) {
        assertEquals(expected, Calculator.divisi(a, b));
    }

    @Test
    @DisplayName("Деление на 0 выбрасывает исключение")
    public void testDivisiByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.divisi(10, 0);
        });
    }
}