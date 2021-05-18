package coursera.algorithms1.week3.classroom

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSortKtTest {

    @Test
    fun testMergeWithSmallerAux() {
        val array = arrayOf(1, 3, 7, 11, 0, 2, 4, 6, 8, 10)
        mergeWithSmallerAux(array, 0, 3, array.lastIndex) { a, b -> a - b }
        assertArrayEquals(arrayOf(0, 1, 2, 3, 4, 6, 7, 8, 10, 11), array)
    }
}
