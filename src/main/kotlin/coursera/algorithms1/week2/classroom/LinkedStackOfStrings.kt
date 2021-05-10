package coursera.algorithms1.week2.classroom

import java.util.*

class LinkedStackOfStrings {
    private class Node {
        lateinit var data: String
        var next: Node? = null
    }

    private var head: Node? = null

    fun push(str: String) {
        val node = Node()
        node.data = str
        node.next = head
        head = node
    }

    fun pop(): String {
        val node = head ?: throw EmptyStackException()
        head = node.next
        return node.data
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}
