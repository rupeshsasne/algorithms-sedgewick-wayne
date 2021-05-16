package coursera.algorithms1.week2.assignments.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntersectionOfSetsKtTest {

    @Test
    fun testIntersection() {
        val a1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val a2 = intArrayOf(2, 4, 6)

        assertEquals(3, sizeOfIntersection(a1, a2))
    }
}
