package coursera.algorithms1.week2.assignments.interview

import java.lang.IllegalStateException
import java.util.*

class QueueBy2Stack<T> {
    private val s1 = Stack<T>()
    private val s2 = Stack<T>()

    private fun <E> Stack<E>.requiresNonEmpty() {
        if (isEmpty())
            throw IllegalStateException("Empty queue")
    }

    fun offer(t: T) {
        s1.push(t)
    }

    fun poll(): T {
        if (s2.isEmpty()) {
            s1.requiresNonEmpty()

            while (s1.isNotEmpty()) {
                s2.push(s1.pop())
            }
        }

        return s2.pop()
    }
}
