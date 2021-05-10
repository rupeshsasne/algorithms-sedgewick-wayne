package coursera.algorithms1.week2.assignments.interview

import java.util.*

class StackWithMax {
    private val ll = LinkedList<Int>()
    private val maxLl = LinkedList<Int>()

    fun push(data: Int) {
        ll.addFirst(data)

        if (maxLl.isEmpty() || maxLl.first < data)
            maxLl.addFirst(data)
    }

    fun pop(): Int {
        val data = ll.removeFirst()

        if (maxLl.first == data)
            maxLl.removeFirst()

        return data
    }

    fun max(): Int = maxLl.first
}