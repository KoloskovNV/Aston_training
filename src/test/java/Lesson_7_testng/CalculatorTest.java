package Lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {10, 5, 15},
                {-5, 0, -5}
        };
    }

    @Test(dataProvider = "addData")
    @DisplayName("Сложение")
    public void testAdd(int a, int b, int expected) {
        assertEquals(Calculator.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {10, 5, 5},
                {-5, 0, -5}
        };
    }

    @Test(dataProvider = "subtractData")
    @DisplayName("Вычитание")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(Calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "multiplData")
    public Object[][] multiplData() {
        return new Object[][]{
                {10, 5, 50},
                {-5, 0, 0}
        };
    }

    @Test(dataProvider = "multiplData")
    @DisplayName("Умножение")
    public void testMultipl(int a, int b, int expected) {
        assertEquals(Calculator.multipl(a, b), expected);
    }

    @DataProvider(name = "divisiData")
    public Object[][] divisiData() {
        return new Object[][]{
                {10, 5, 2.0},
                {-5, 1, -5.0}
        };
    }

    @Test(dataProvider = "divisiData")
    @DisplayName("Деление")
    public void testDivisi(int a, int b, double expected) {
        assertEquals(Calculator.divisi(a, b), expected, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    @DisplayName("Деление на 0 выбрасывает исключение")
    public void testDivisiByZero() {
        Calculator.divisi(10, 0);
    }
}