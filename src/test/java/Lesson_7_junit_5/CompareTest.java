package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareTest {

    private final Compare compare = new Compare();

    @Test
    @DisplayName("Числа равны (5 = 5)")
    public void testIsEqual() {
        assertTrue(compare.isEqual(5, 5));
        assertFalse(compare.isEqual(5, 6));
    }

    @Test
    @DisplayName("Первое число больше второго (10 > 5)")
    public void testIsGreater() {
        assertTrue(compare.isGreater(10, 5));
        assertFalse(compare.isGreater(5, 10));
    }

    @Test
    @DisplayName("Первое число меньше второго (3 < 7)")
    public void testIsLess() {
        assertTrue(compare.isLess(3, 7));
        assertFalse(compare.isLess(7, 3));
        assertFalse(compare.isLess(5, 5));
    }

    @Test
    @DisplayName("Большее число из 10 и 5 равно 10")
    public void testMax() {
        assertEquals(10, compare.max(10, 5));
        assertEquals(10, compare.max(5, 10));
        assertEquals(5, compare.max(5, 5));
    }

    @Test
    @DisplayName("Меньшее число из 10 и 5 равно 5")
    public void testMin() {
        assertEquals(5, compare.min(10, 5));
        assertEquals(5, compare.min(5, 10));
        assertEquals(5, compare.min(5, 5));
    }
}