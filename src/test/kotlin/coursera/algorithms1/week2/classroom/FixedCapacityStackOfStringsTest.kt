package coursera.algorithms1.week2.classroom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class FixedCapacityStackOfStringsTest {
    private val testObject = FixedCapacityStackOfStrings(5)

    @Test
    fun testEmptyStack() {
        assertThrows<EmptyStackException> {
            testObject.pop()
        }
    }

    @Test
    fun testPop() {
        testObject.push("abc")
        testObject.push("pqr")

        assertEquals("pqr", testObject.pop())
        assertEquals("abc", testObject.pop())
        assertThrows<EmptyStackException> { testObject.pop() }
    }

    @Test
    fun testFullStack() {
        testObject.push("abc")
        testObject.push("pqr")
        testObject.push("abc")
        testObject.push("pqr")
        testObject.push("abc")

        assertThrows<FixedCapacityStackOfStrings.StackOverflowException> {
            testObject.push("pqr")
        }
    }
}
