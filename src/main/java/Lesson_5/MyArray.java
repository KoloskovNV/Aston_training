package Lesson_5;

public class MyArray {
    private static final int EXPECTED_SIZE = 4;

    private MyArray() {
        throw new UnsupportedOperationException("Класс не может быть создан");
    }

    public static void validateArray(String[][] array) throws MyArraySizeException {
        if (array == null) {
            throw new MyArraySizeException("Массив не должен быть null");
        }
        if (array.length != EXPECTED_SIZE) {
            throw new MyArraySizeException(String.format("Неверное количество строк: %d. Должно быть %d.", array.length, EXPECTED_SIZE));
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException(String.format("Строки с индексом %d нет", i));
            }
            if (array[i].length != EXPECTED_SIZE) {
                throw new MyArraySizeException(String.format("Неверное количество столбцов в строке с индексом %d: %d. Должно быть %d.", i, array[i].length, EXPECTED_SIZE));
            }
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        validateArray(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    throw new MyArrayDataException(String.format("Ячейки [%d][%d] нет", i, j), i, j, "null");
                }
                try {
                    int value = Integer.parseInt(array[i][j].trim());
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Неверные данные в ячейке [%d][%d]: \"%s\" не является числом", i, j, array[i][j]), i, j, array[i][j], e);
                }
            }
        }
        return sum;
    }
}