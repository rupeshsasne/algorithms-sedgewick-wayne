package coursera.algorithms1.week1.assignments.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SuccessorWithDeleteTest {

    @Test
    fun test() {
        val testObject = SuccessorWithDelete(10)

        testObject.remove(5)
        assertEquals(6, testObject.successor(5))

        testObject.remove(9)
        assertNull(testObject.successor(9))

        testObject.remove(0)
        assertEquals(1, testObject.successor(0))

        testObject.remove(6)
        testObject.remove(7)
        assertEquals(8, testObject.successor(5))

        testObject.remove(4)
        assertEquals(8, testObject.successor(4))

        testObject.remove(8)
        assertNull(testObject.successor(4))
    }
}
