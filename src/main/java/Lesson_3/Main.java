package Lesson_3;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 117943.00, true);
        productsArray[1] = new Product("Xiaomi 17 Pro Max", "25.09.2025",
                "Xiaomi", "China", 75416.00, true);
        productsArray[2] = new Product("iPhone 17 Pro Max", "09.09.2025",
                "Apple Inc.", "USA", 120990.00, false);
        productsArray[3] = new Product("Samsung Galaxy Fold7 5G", "25.07.2025",
                "Samsung Corp.", "Korea", 149999.00, false);
        productsArray[4] = new Product("Xiaomi 15 Ultra", "27.02.2025",
                "Xiaomi", "China", 139500.00, true);
        System.out.println("Товары:");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар №" + (i + 1) + ":");
            productsArray[i].printInfo();
        }
        System.out.println();
        System.out.println("Парки:");
        Park park1 = new Park("Городской парк имени Горького", "Саратов");
        Park.Attraction ride1 = park1.new Attraction("Сюрприз", "10:00 - 20:00", 400);
        park1.setAttraction(ride1);
        Park park2 = new Park("Парк культуры и отдыха имени Ю. А. Гагарина", "Самара");
        Park.Attraction ride2 = park2.new Attraction("Колесо обозрения", "10:00 - 20:00", 500);
        park2.setAttraction(ride2);
        System.out.println("Парк 1:");
        park1.getAttraction().printInfo();
        System.out.println("Парк 2:");
        park2.getAttraction().printInfo();
    }
}