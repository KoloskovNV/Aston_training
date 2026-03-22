package Lesson_4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Животные:");
        System.out.println();
        System.out.println("Бег и плавание:");
        Cat cat1 = new Cat("Черный кот");
        Cat cat2 = new Cat("Рыжий кот");
        Cat cat3 = new Cat("Серый кот");
        Dog dog1 = new Dog("Такса");
        Dog dog2 = new Dog("Дог");
        Dog dog3 = new Dog("Овчарка");
        System.out.println("Бег:");
        cat1.run(100);
        cat2.run(200);
        cat3.run(300);
        dog1.run(400);
        dog2.run(500);
        dog3.run(600);
        System.out.println("Плавание:");
        cat1.swim(0);
        cat2.swim(5);
        cat3.swim(10);
        dog1.swim(5);
        dog2.swim(10);
        dog3.swim(15);
        System.out.println("Количество животных:");
        System.out.println("Всего животных: " + Animal.getNumberAnimal());
        System.out.println("Котов: " + Animal.getNumberCat());
        System.out.println("Собак: " + Animal.getNumberDog());
        System.out.println();
        System.out.println("Коты и миска:");
        Cat[] cats = {new Cat("Серый кот"), new Cat("Черный кот"), new Cat("Рыжий кот"), new Cat("Белый кот")};
        Bowl bowl = new Bowl(35);
        bowl.printInfo();
        System.out.println("Коты кушают: ");
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }
        System.out.println();
        System.out.println("Проверка сытости котов:");
        for (Cat cat : cats) {
            cat.printCatStatus();
        }
        System.out.println();
        bowl.printInfo();
        System.out.println("Добавим еще 30 еды в миску");
        bowl.addFood(30);
        System.out.println("Голодные коты кушают");
        for (Cat cat : cats) {
            if (!cat.isNotHungry()) {
                cat.eat(bowl, 15);
            }
        }
        bowl.printInfo();
        System.out.println();
        System.out.println("Проверка сытости котов:");
        for (Cat cat : cats) {
            cat.printCatStatus();
        }
        System.out.println();
        System.out.println("Итоговое количество животных:");
        System.out.println("Всего животных: " + Animal.getNumberAnimal());
        System.out.println("Котов: " + Animal.getNumberCat());
        System.out.println("Собак: " + Animal.getNumberDog());
        System.out.println();
        System.out.println("Геометрические фигуры");
        System.out.println();
        Shape[] figures = new Shape[3];
        figures[0] = new Circle(5.0, "Синий", "Черный");
        figures[1] = new Rectangle(6.0, 7.0, "Красный", "Черный");
        figures[2] = new Triangle(8.0, 9.0, 10.0, "Белый", "Зеленый");
        for (Shape shape : figures) {
            shape.printInfo();
        }
    }
}
