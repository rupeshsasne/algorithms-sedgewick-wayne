package coursera.algorithms1.week2.classroom

import java.util.EmptyStackException

class LinkedStack<T> {
    private class Node<E> {
        var data: E? = null
        var next: Node<E>? = null
    }

    private var head: Node<T>? = null

    fun push(data: T) {
        val node = Node<T>()
        node.data = data
        node.next = head
        head = node
    }

    fun pop(): T? {
        val node = head ?: throw EmptyStackException()
        head = node.next
        return node.data
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}
