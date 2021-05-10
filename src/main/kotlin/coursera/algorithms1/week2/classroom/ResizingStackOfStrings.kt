package coursera.algorithms1.week2.classroom

import java.util.*

class ResizingStackOfStrings {
    private var array = Array<String?>(1) { null }
    private var top = 0

    private fun resize(newSize: Int) {
        val copy = Array(newSize) {
            if (it <= array.lastIndex) {
                array[it]
            } else {
                null
            }
        }

        array = copy
    }

    fun push(str: String) {
        if (top == array.size)
            resize(2 * array.size)

        array[top++] = str
    }

    fun pop(): String {
        if (isEmpty()) throw EmptyStackException()

        if (top == array.size / 4)
            resize(array.size / 2)

        val str = array[--top]
        array[top] = null
        return str!!
    }

    fun isEmpty(): Boolean {
        return top == 0
    }
}
