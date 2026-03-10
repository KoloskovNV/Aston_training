package Lesson_3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean reservationStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin,
                   double price, boolean reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public void printInfo() {
        String status = reservationStatus ? "Забронировано" : "Свободно";
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Статус: " + status);
    }
}
