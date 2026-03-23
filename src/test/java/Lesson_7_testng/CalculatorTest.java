package Lesson_7_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    public final Calculator calculator = new Calculator();

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {10, 5, 15},
                {-5, 0, -5}
        };
    }

    @Test(dataProvider = "addData", description = "Сложение")
    public void testAdd(int a, int b, int expected) {
        assertEquals(calculator.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {10, 5, 5},
                {-5, 0, -5}
        };
    }

    @Test(dataProvider = "subtractData", description = "Вычитание")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] multiplyData() {
        return new Object[][]{
                {10, 5, 50},
                {-5, 0, 0}
        };
    }

    @Test(dataProvider = "multiplyData", description = "Умножение")
    public void testMultiply(int a, int b, int expected) {
        assertEquals(calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][]{
                {10, 5, 2.0},
                {-5, 1, -5.0}
        };
    }

    @Test(dataProvider = "divideData", description = "Деление")
    public void testDivsde(int a, int b, double expected) {
        assertEquals(calculator.divide(a, b), expected, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class, description = "Деление на 0 выбрасывает исключение")
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}