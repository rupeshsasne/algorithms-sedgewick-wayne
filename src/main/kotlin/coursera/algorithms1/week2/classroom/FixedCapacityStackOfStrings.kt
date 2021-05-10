package coursera.algorithms1.week2.classroom

import java.lang.RuntimeException
import java.util.*

class FixedCapacityStackOfStrings(private val size: Int) {

    class StackOverflowException(size: Int) :
        RuntimeException("Stack capacity exceeded, can accommodate $size elements only")

    private val array: Array<String?> = Array(size) { null }

    private var top = 0

    fun push(str: String) {
        if (top == size) throw StackOverflowException(size)

        array[top++] = str
    }

    fun pop(): String {
        if (isEmpty()) throw EmptyStackException()

        val str = array[--top]
        array[top] = null
        return str!!
    }

    fun isEmpty(): Boolean {
        return top == 0
    }
}