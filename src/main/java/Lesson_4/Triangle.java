package Lesson_4;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        if (!validateParam(sideA) || !validateParam(sideB) || !validateParam(sideC)) {
            throw new IllegalArgumentException("Стороны не могут быть отрицательными!");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)); }
    @Override
    public double getPerimeter() { return sideA + sideB + sideC; }
    @Override
    public String getName() { return "Треугольник"; }
    @Override
    public String getFillColor() { return fillColor; }
    @Override
    public void setFillColor(String color) { this.fillColor = color; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public void setBorderColor(String color) { this.borderColor = color; }
}