package book.chapter1.section1

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOut
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    var whitelist = In(args[0]).readAllInts()
    whitelist.sort()
    whitelist = whitelist.distinct().toIntArray()

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
