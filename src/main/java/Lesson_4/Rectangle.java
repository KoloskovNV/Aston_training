package Lesson_4;

public class Rectangle implements Shape {
    private double sideA;
    private double sideB;
    private String fillColor;
    private String borderColor;

    public Rectangle(double sideA, double sideB, String fillColor, String borderColor) {
        if (!validateParam(sideA) || ! validateParam(sideB)) {
            throw new IllegalArgumentException("Стороны не могут быть отрицательными!");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea() { return sideA * sideB; }
    @Override
    public double getPerimeter() { return 2 * (sideA + sideB); }
    @Override
    public String getName() { return "Прямоугольник"; }
    @Override
    public String getFillColor() { return fillColor; }
    @Override
    public void setFillColor(String color) { this.fillColor = color; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public void setBorderColor(String color) { this.borderColor = color; }
}
