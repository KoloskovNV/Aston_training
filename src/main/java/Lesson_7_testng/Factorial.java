package Lesson_7_testng;

public class Factorial {
    public static long calculate(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определён только для неотрицательных чисел");
        }

        long result = 1;
        for (long i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}