package coursera.algorithms1.week3.assignments.interview

import java.util.*

// Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j] such that i < j but a[i] > a[j].
// Given an array, design a linear arithmetic algorithm to count the number of inversions.
fun sort(array: IntArray, aux: IntArray, lo: Int, hi: Int): Long {
    if (lo >= hi) return 0

    val mid = lo + (hi - lo) / 2

    var inversions: Long = sort(array, aux, lo, mid)
    inversions += sort(array, aux, mid + 1, hi)

    return inversions + merge(array, aux, lo, mid, hi)
}

fun merge(array: IntArray, aux: IntArray, lo: Int, mid: Int, hi: Int): Long {
    System.arraycopy(array, lo, aux, lo, (hi - lo) + 1)

    var i = lo
    var j = mid + 1

    val nextToMid = j
    var inversions = 0L

    for (k in lo..hi) {
        when {
            i > mid -> array[k] = aux[j++]
            j > hi -> array[k] = aux[i++]
            aux[i] > aux[j] -> {
                array[k] = aux[j++]
                inversions += nextToMid - i
            }
            else -> array[k] = aux[i++]
        }
    }

    return inversions
}

fun countInversions(array: IntArray): Long {
    return sort(array, IntArray(array.size), 0, array.size - 1)
}

fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

        val result = countInversions(arr)

        println(result)
    }
}
