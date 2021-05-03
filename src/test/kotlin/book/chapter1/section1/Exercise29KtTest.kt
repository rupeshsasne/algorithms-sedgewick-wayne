package book.chapter1.section1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Exercise29KtTest {

    @Test
    fun testLessThanKey() {
        val input = intArrayOf(1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10)
            .distinct()
            .toIntArray()

        assertEquals(0, input.lessThanKey(0))
        assertEquals(10, input.lessThanKey(11))
        assertEquals(4, input.lessThanKey(5))
    }

    @Test
    fun testEqualsToKey() {
        val input = intArrayOf(1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10)
        assertEquals(2, input.equalsToKey(6))
    }
}
