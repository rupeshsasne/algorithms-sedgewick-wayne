package chapter1.section1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Exercise20KtTest {

    @ParameterizedTest(name = "#{index} - Run test with arg = {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun testFactorial(n: Int) {
        val fact: Int = (1..n).reduce { a, b -> a * b }
        assertEquals(fact, factorial(n))
    }
}
