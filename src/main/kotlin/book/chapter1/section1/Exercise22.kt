package book.chapter1.section1

import edu.princeton.cs.algs4.StdOut

fun rank(key: Int, arr: IntArray): Int {
    val sb = StringBuilder()
    val rank = rank(key, arr, 0, arr.lastIndex, 0, sb)
    StdOut.print(sb.toString())
    return rank
}

private fun rank(key: Int, arr: IntArray, lo: Int, hi: Int, depth: Int, strBuilder: StringBuilder): Int {
    with(strBuilder) {
        if (length > 0)
            append("\n")

        for (i in 0..depth) {
            append("*")
        }
        append("$lo, $hi")
    }

    if (lo > hi) return -1

    val mid = lo + (hi - lo) / 2

    return when {
        key < arr[mid] -> rank(key, arr, lo, mid - 1, depth + 1, strBuilder)
        key > arr[mid] -> rank(key, arr, mid + 1, hi, depth + 1, strBuilder)
        else -> mid
    }
}
