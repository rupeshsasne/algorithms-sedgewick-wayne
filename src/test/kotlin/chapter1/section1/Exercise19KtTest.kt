package chapter1.section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.opentest4j.AssertionFailedError
import java.time.Duration

class Exercise19KtTest {

    @Test
    fun fibRecursive() {
        assertThrows(AssertionFailedError::class.java) {
            assertTimeout(Duration.ofSeconds(2)) {
                fibRecursive(46)
            }
        }
    }

    @Test
    fun fibIterative() {
        val term = fibIterative(46)
        assertEquals(1836311903, term)
    }
}
