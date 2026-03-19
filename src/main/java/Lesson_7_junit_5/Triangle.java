package Lesson_7_junit_5;

public class Triangle {
    public static double area(double base, double height) {
        if (base <= 0) {
            throw new IllegalArgumentException("Основание должно быть > 0: " + base);
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Высота должна быть > 0: " + height);
        }
        return (base * height) / 2.0;
    }
}