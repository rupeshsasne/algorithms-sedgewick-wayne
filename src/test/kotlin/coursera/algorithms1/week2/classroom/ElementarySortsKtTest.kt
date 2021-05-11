package coursera.algorithms1.week2.classroom

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ElementarySortsKtTest {

    @Test
    fun swap() {
        val array = arrayOf(4, 3, 1, 2, 5)
        array.swap(1, 2)
        assertArrayEquals(arrayOf(4, 1, 3, 2, 5), array)
    }

    @Test
    fun selectionSort() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).apply { shuffle() }
        array.selectionSort { t1, t2 -> t1 - t2 }
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), array)
    }

    @Test
    fun insertionSort() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).apply { shuffle() }
        array.insertionSort { t1, t2 -> t1 - t2 }
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), array)
    }
}
