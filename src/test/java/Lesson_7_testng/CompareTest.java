package Lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompareTest {

    @Test
    @DisplayName("Числа равны (5 = 5)")
    public void testIsEqual() {
        assertTrue(Compare.isEqual(5, 5));
        assertFalse(Compare.isEqual(5, 6));
    }
    @Test
    @DisplayName("Первое число больше второго (10 > 5)")
    public void testIsGreater() {
        assertTrue(Compare.isGreater(10, 5));
        assertFalse(Compare.isGreater(5, 10));
    }

    @Test
    @DisplayName("Первое число меньше второго (3 < 7)")
    public void testIsLess() {
        assertTrue(Compare.isLess(3, 7));
        assertFalse(Compare.isLess(7, 3));
        assertFalse(Compare.isLess(5, 5));
    }

    @Test
    @DisplayName("Большее число из 10 и 5 равно 10")
    public void testMax() {
        assertEquals(Compare.max(10, 5), 10);
        assertEquals(Compare.max(5, 10), 10);
        assertEquals(Compare.max(5, 5), 5);
    }

    @Test
    @DisplayName("Меньшее число из 10 и 5 равно 5")
    public void testMin() {
        assertEquals(Compare.min(10, 5), 5);
        assertEquals(Compare.min(5, 10), 5);
        assertEquals(Compare.min(5, 5), 5);
    }
}
