package chapter1.section1

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class Exercise30KtTest {

    @Test
    fun testCreateRelativelyPrimeArray() {
        val expectedArray = Array(3) {
            when (it) {
                0 -> arrayOf(false, true, false)
                1 -> arrayOf(true, true, true)
                else -> arrayOf(false, true, false)
            }
        }

        val array = createRelativelyPrimeArray(3)

        assertArrayEquals(expectedArray, array)
    }
}
