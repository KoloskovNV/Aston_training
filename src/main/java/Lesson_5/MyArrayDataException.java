package Lesson_5;

public class MyArrayDataException extends Exception {
    private final int row;
    private final int column;
    private final String invalidValue;

    public MyArrayDataException(String message, int row, int col, String invalidValue) {
        super(message);
        this.row = row;
        this.column = col;
        this.invalidValue = invalidValue;
    }

    public MyArrayDataException(String message, int row, int col, String invalidValue, Throwable cause) {
        super(message, cause);
        this.row = row;
        this.column = col;
        this.invalidValue = invalidValue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getInvalidValue() {
        return invalidValue;
    }
}
