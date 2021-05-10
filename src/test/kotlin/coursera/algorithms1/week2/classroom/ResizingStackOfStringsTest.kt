package coursera.algorithms1.week2.classroom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class ResizingStackOfStringsTest {
    private val testObject = ResizingStackOfStrings()

    @Test
    fun testPush() {
        testObject.push("abc")
        testObject.push("abc")
        testObject.push("abc")
        testObject.push("abc")
        testObject.push("abc")

        assertEquals("abc", testObject.pop())
        assertEquals("abc", testObject.pop())
        assertEquals("abc", testObject.pop())
        assertEquals("abc", testObject.pop())
        assertEquals("abc", testObject.pop())

        assertThrows<EmptyStackException> {
           testObject.pop()
        }
    }
}
