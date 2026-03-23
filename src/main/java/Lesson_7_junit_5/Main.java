package Lesson_7_junit_5;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        Triangle triangle = new Triangle();
        Calculator calculator = new Calculator();
        Compare compare = new Compare();
        System.out.println("\nФакториал");
        try {
            System.out.println("3 = " + factorial.calculate(3));
            System.out.println("10 = " + factorial.calculate(10));
            System.out.println("-5! = " + factorial.calculate(-5));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПлощадь треугольника");
        try {
            System.out.println("S = " + triangle.area(5.0, 6.0));
            System.out.println("S = " + triangle.area(-5.0, 6.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nКалькулятор");
        System.out.println("10 + 5 = " + calculator.add(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + calculator.multiply(10, 5));
        try {
            System.out.println("10 / 5 = " + calculator.divide(10, 5));
            System.out.println("10 / 0 = " + calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nСравнение чисел");
        System.out.println("10 > 5? " + compare.isGreater(10, 5));
        System.out.println("10 < 5? " + compare.isLess(10, 5));
        System.out.println("10 = 10? " + compare.isEqual(10, 10));
        System.out.println("Max(10, 5) = " + compare.max(10, 5));
        System.out.println("Min(10, 5) = " + compare.min(10, 5));
    }
}
