package Lesson_7_junit_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nФакториал");
        try {
            System.out.println("3 = " + Factorial.calculate(3));
            System.out.println("10 = " + Factorial.calculate(10));
            System.out.println("-5! = " + Factorial.calculate(-5));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПлощадь треугольника");
        try {
            System.out.println("S = " + Triangle.area(5.0, 6.0));
            System.out.println("S = " + Triangle.area(-5.0, 6.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nКалькулятор");
        System.out.println("10 + 5 = " + Calculator.add(10, 5));
        System.out.println("10 - 5 = " + Calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + Calculator.multipl(10, 5));
        try {
            System.out.println("10 / 5 = " + Calculator.divisi(10, 5));
            System.out.println("10 / 0 = " + Calculator.divisi(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nСравнение чисел");
        System.out.println("10 > 5? " + Compare.isGreater(10, 5));
        System.out.println("10 < 5? " + Compare.isLess(10, 5));
        System.out.println("10 = 10? " + Compare.isEqual(10, 10));
        System.out.println("Max(10, 5) = " + Compare.max(10, 5));
        System.out.println("Min(10, 5) = " + Compare.min(10, 5));
    }
}