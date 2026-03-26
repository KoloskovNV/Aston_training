package Lesson_7_testng;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multipl(int a, int b) {
        return a * b;
    }

    public static double divisi(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0 невозможно");
        }
        return (double) a / b;
    }
}
