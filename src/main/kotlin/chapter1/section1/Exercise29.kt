package chapter1.section1

import kotlin.math.abs

private fun IntArray.binarySearch(key: Int): Int {
    var lo = 0
    var hi = lastIndex

    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2

        when {
            key > this[mid] -> lo = mid + 1
            key < this[mid] -> hi = mid - 1
            else -> {
                return mid
            }
        }
    }

    return -(lo + 1)
}

fun IntArray.lessThanKey(key: Int): Int {
    val insertionIndex = this.binarySearch(key)

    return if (insertionIndex < 0) {
        abs(insertionIndex) - 1
    } else {
        insertionIndex
    }
}
