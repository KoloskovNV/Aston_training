package Lesson_2;

public class Main {

    // задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //задание 2
    public static void checkSumSign() {
        int a = 10;
        int b = 15;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательна");
        }
    }

    //задание 3
    public static void printColor() {
        int volume = 100;
        if (volume <= 0) {
            System.out.println("Красный");
        }
        else if (volume > 100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }
    }

    //задание 4
    public static void compareNumbers() {
        int a = 25;
        int b = 50;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //задание 5
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //задание 6
    public static void printPositiveOrNegative(int newNumber) {
        if (newNumber >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //задание 7
    public static boolean isNegativeOrPositive(int integerNumber) {
        return integerNumber < 0;
    }

    //задание 8
    public static void repitString(String str, int number) {
        for (int i = 0; i < number; i++)
            System.out.println(str);
    }

    //задание 9
    public static boolean isleapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //задание 10
    public static void invertBinaryArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        printArray(array);
    }

//задание 11
    public static void emptyArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        printArray(array);
    }

//задание 12
    public static void newArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        printArray(array);
    }

//задание 13
    public static void diagonalMatrix() {
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - 1 - i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

//задание 14
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

// вывод результатов
    public static void main(String[] array) {
        checkSumSign();
        printThreeWords();
        printColor();
        compareNumbers();
        System.out.println("Сумма в диапозоне: " + isSumInRange(5, 10));
        System.out.println("Сумма в диапозоне: " + isSumInRange(15, 20));
        printPositiveOrNegative(10);
        printPositiveOrNegative(-10);
        System.out.println("Сумма в диапозоне: " + isNegativeOrPositive(-10));
        System.out.println("Сумма в диапозоне: " + isNegativeOrPositive(10));
        repitString("JAVA training", 5);
        System.out.println("Год високосный: " + isleapYear(2026));
        System.out.println("Год високосный: " + isleapYear(2020));
        System.out.println("Год високосный: " + isleapYear(1600));
        invertBinaryArray();
        emptyArray();
        newArray();
        diagonalMatrix();
        int[] startPrintArray = createArray(8, 5);
        printArray(startPrintArray);
    }

//метод для вывода массивов
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}