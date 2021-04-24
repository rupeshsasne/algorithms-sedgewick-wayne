package chapter1.section1

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercise15KtTest {

    @Test
    fun testHistogramNaturalOrder() {
        val a = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val result = histogram(a, 10)

        assertEquals(a.size, result.size)
        assertEquals(10, result.sum())
    }

    @Test
    fun testHistogramRandomNumbers() {
        val a = intArrayOf(4, 3, 1, 0, 2, 1, 8, 100, 32)
        val result = histogram(a, 10)

        assertArrayEquals(intArrayOf(1, 2, 1, 1, 1, 0, 0, 0, 1, 0), result)
    }
}
