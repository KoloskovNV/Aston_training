package Lesson_4;

public interface Shape extends Colored{
    double getPerimeter();
    double getArea();
    String getName();

    default void printInfo() {
        System.out.println("Фигура: " + getName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }

    default boolean validateParam(double param) {
        return param > 0;
    }
}