package coursera.algorithms1.week3.assignments.interview

import edu.princeton.cs.algs4.StdRandom

class ShuffleLinkedList<T> : Iterable<T> {
    private class Node<E>(var data: E, var next: Node<E>? = null)

    private var head: Node<T>? = null

    fun addFirst(data: T) {
        val node = Node(data)
        node.next = head
        head = node
    }

    fun isEmpty() =
        head == null

    fun shuffle() {
        val curr = head ?: throw NoSuchElementException()
        head = shuffle(curr)
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var curr = head

            override fun hasNext(): Boolean =
                curr != null

            override fun next(): T {
                val temp = curr ?: throw NoSuchElementException()
                curr = curr?.next
                return temp.data
            }
        }
    }

    private fun shuffle(head: Node<T>?): Node<T>? {
        if (head?.next == null) return head

        val mid = middleNode(head)
        val nextToMid = mid?.next
        mid?.next = null

        val left = shuffle(head)
        val right = shuffle(nextToMid)

        return merge(left, right)
    }

    private fun merge(left: Node<T>?, right: Node<T>?): Node<T>? {
        if (left == null)
            return right

        if (right == null)
            return left

        val toss = StdRandom.uniform(2)

        val result: Node<T>?

        if (toss == 0) {
            result = right
            result.next = merge(left, right.next)
        } else {
            result = left
            result.next = merge(left.next, right)
        }

        return result
    }

    private fun middleNode(head: Node<T>?): Node<T>? {
        var slow: Node<T>? = head
        var fast: Node<T>? = head?.next

        while (fast != null) {
            fast = fast.next

            fast?.let {
                fast = it.next
                slow = slow?.next
            }
        }

        return slow
    }
}


fun main() {
    val str = ShuffleLinkedList<Int>()
        .apply { addFirst(1) }
        .apply { addFirst(2) }
        .apply { addFirst(3) }
        .apply { addFirst(4) }
        .apply { addFirst(5) }
        .apply { addFirst(6) }
        .apply { addFirst(7) }
        .apply { shuffle() }
        .joinToString()

    println(str)
}