package Lesson_7_testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompareTest {
    private final Compare compare = new Compare();

    @Test(description = "Числа равны (5 = 5)")
    public void testIsEqual() {
        assertTrue(compare.isEqual(5, 5));
        assertFalse(compare.isEqual(5, 6));
    }
    @Test(description = "Первое число больше второго (10 > 5)")
    public void testIsGreater() {
        assertTrue(compare.isGreater(10, 5));
        assertFalse(compare.isGreater(5, 10));
    }

    @Test(description = "Первое число меньше второго (3 < 7)")
    public void testIsLess() {
        assertTrue(compare.isLess(3, 7));
        assertFalse(compare.isLess(7, 3));
        assertFalse(compare.isLess(5, 5));
    }

    @Test(description = "Большее число из 10 и 5 равно 10")
    public void testMax() {
        assertEquals(compare.max(10, 5), 10);
        assertEquals(compare.max(5, 10), 10);
        assertEquals(compare.max(5, 5), 5);
    }

    @Test(description = "Меньшее число из 10 и 5 равно 5")
    public void testMin() {
        assertEquals(compare.min(10, 5), 5);
        assertEquals(compare.min(5, 10), 5);
        assertEquals(compare.min(5, 5), 5);
    }
}
