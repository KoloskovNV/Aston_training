package Lesson_4;

public class Animal {
    protected String name;
    protected int runningLenght;
    protected int swimmingLenght;
    protected boolean swimming;
    protected static int numberAnimal = 0;
    protected static int numberCat = 0;
    protected static int numberDog = 0;

    public Animal(String name, int runningLenght, int swimmingLenght, boolean swimming) {
        this.name = name;
        this.runningLenght = runningLenght;
        this.swimmingLenght = swimmingLenght;
        this.swimming = swimming;
        numberAnimal++;
    }

    public void run(int lenght) {
        if (lenght <= runningLenght) {
            System.out.println(name + " пробежал " + lenght + " м");
        } else {
            System.out.println(name + " не пробежал " + lenght + " м, " + "больше " + runningLenght + " м пробежать не может");
        }
    }

    public void swim(int lenght) {
        if (!swimming) {
            System.out.println(name + " не умеет плавать");
            return;
        }
        if (lenght <= swimmingLenght) {
            System.out.println(name + " проплыл " + lenght + " м");
        } else {
            System.out.println(name + " не проплыл " + lenght + " м, " + "больше " + swimmingLenght + " м проплыть не может");
        }
    }

    public static int getNumberAnimal() {
        return numberAnimal;
    }

    public static int getNumberCat() {
        return numberCat;
    }

    public static int getNumberDog() {
        return numberDog;
    }
}