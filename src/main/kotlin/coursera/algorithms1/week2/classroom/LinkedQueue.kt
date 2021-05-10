package coursera.algorithms1.week2.classroom

import java.lang.RuntimeException

class LinkedQueue<T> : Iterable<T?> {

    class EmptyQueueException : RuntimeException()

    private class Node<E> {
        var data: E? = null
        var next: Node<E>? = null
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun isEmpty() =
        head == null

    fun enqueue(data: T) {
        val oldTail = tail

        tail = Node()
        tail?.let {
            it.data = data
            it.next = null
        }

        if (isEmpty()) {
            head = tail
        } else {
            oldTail?.next = tail
        }
    }

    fun dequeue(): T? {
        if (isEmpty())
            throw EmptyQueueException()

        val node = head
        head = head?.next

        if (isEmpty())
            tail = null

        return node?.data
    }

    override fun iterator(): Iterator<T?> {
        return object : Iterator<T?> {
            private var curr = head

            override fun hasNext(): Boolean =
                curr != null

            override fun next(): T? {
                val data = curr?.data
                curr = curr?.next
                return data
            }
        }
    }
}
