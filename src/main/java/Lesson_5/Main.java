package Lesson_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование валидации массива\n");
        System.out.println("Тест 1: Правильный массив 4x4");
        String[][] correctArray = {{"A1", "A2", "A3", "A4"}, {"B1", "B2", "B3", "B4"}, {"C1", "C2", "C3", "C4"}, {"D1", "D2", "D3", "D4"}};
        try {
            MyArray.validateArray(correctArray);
            System.out.println("Валидация пройдена");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nТест 2: Мало строк");
        String[][] wrongRows = new String[3][4];
        try {
            MyArray.validateArray(wrongRows);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nТест 3: Много строк");
        String[][] tooManyRows = new String[5][4];
        try {
            MyArray.validateArray(tooManyRows);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nТест 4: Разная длина строк");
        String[][] differentLineLengths = {{"a", "b", "c", "d"}, {"a", "b"}, {"a", "b", "c", "d"}, {"a", "b", "c", "d"}};
        try {
            MyArray.validateArray(differentLineLengths);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nТест 5: Нет строки");
        String[][] nullRowArray = new String[4][];
        nullRowArray[0] = new String[4];
        nullRowArray[1] = null;
        nullRowArray[2] = new String[4];
        nullRowArray[3] = new String[4];
        try {
            MyArray.validateArray(nullRowArray);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nТест 6: Нет массива");
        try {
            MyArray.validateArray(null);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nСуммирование и обработка исключений\n");
        System.out.println("Тест 7: Корректные числовые данные");
        String[][] numericArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int result = MyArray.sumArrayElements(numericArray);
            System.out.println("Результат расчета: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
            System.out.println("Ячейка: [" + e.getRow() + "][" + e.getColumn() + "]");
            System.out.println("Значение: " + e.getInvalidValue());
        }
        System.out.println("\nТест 8: Буква вместо числа (MyArrayDataException)");
        String[][] arrayWithLetter = {{"1", "2", "3", "4"}, {"5", "X", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int result = MyArray.sumArrayElements(arrayWithLetter);
            System.out.println("Результат расчета: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
            System.out.println("Ячейка: [" + e.getRow() + "][" + e.getColumn() + "]");
            System.out.println("Значение: " + e.getInvalidValue());
            if (e.getCause() != null) {
                System.out.println("Причина: " + e.getCause().getClass().getSimpleName());
            }
        }
        System.out.println("\nТест 9: Ошибка размера массива");
        String[][] wrongSizeArray = new String[3][4];
        try {
            int result = MyArray.sumArrayElements(wrongSizeArray);
            System.out.println("Результат расчета: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }
        System.out.println("\nArrayIndexOutOfBoundsException\n");
        System.out.println("Тест 10: Выход за границы по строке");
        String[][] testArray = new String[4][4];
        try {
            String value = testArray[10][0];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение: ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
        }
        System.out.println("\nТест 11: Выход за границы по столбцу");
        try {
            String value = testArray[0][10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение: ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
        }
        System.out.println("\nТест 12: Отрицательный индекс");
        try {
            String value = testArray[-1][0];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение: ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}