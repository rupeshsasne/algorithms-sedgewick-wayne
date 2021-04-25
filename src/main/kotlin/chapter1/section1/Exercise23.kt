package chapter1.section1

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut
import java.lang.IllegalArgumentException

object BinarySearch {

    fun rank(key: Int, array: IntArray): Int {
        var lo = 0
        var hi = array.lastIndex

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            when {
                key < array[mid] -> hi = mid - 1
                key > array[mid] -> lo = mid + 1
                else -> return mid
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val whitelist = In(args[0]).readAllInts()
    whitelist.sort()

    val operator: Char = args[1][0]

    if (operator != '+' && operator != '-')
        throw IllegalArgumentException("Invalid argument $operator")

    while (!StdIn.isEmpty()) {
        val key = StdIn.readInt()
        val result = BinarySearch.rank(key, whitelist)

        when {
            operator == '+' && result == -1 -> StdOut.println(key)
            operator == '-' && result != -1 -> StdOut.println(key)
        }
    }
}
