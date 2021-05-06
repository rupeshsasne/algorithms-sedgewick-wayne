package coursera.algorithms1.week1.assignments.interview

class UnionFindWithSpecificCanonicalElement(n: Int) {
    private val ids = IntArray(n) { it }
    private val largestValueAt = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    private fun root(p: Int): Int {
        var trav = p

        while (ids[trav] != trav) {
            ids[trav] = ids[ids[trav]]
            trav = ids[trav]
        }

        return trav
    }

    fun find(i: Int): Int =
        largestValueAt[root(i)]

    fun connected(p: Int, q: Int): Boolean =
        root(p) == root(q)

    fun union(p: Int, q: Int) {
        val pRoot = root(p)
        val qRoot = root(q)

        if (pRoot == qRoot) return

        val newRoot: Int
        val oldRoot: Int

        if (size[pRoot] > size[qRoot]) {
            ids[qRoot] = pRoot
            size[pRoot] += size[qRoot]

            newRoot = pRoot
            oldRoot = qRoot
        } else {
            ids[pRoot] = qRoot
            size[qRoot] += size[pRoot]

            newRoot = qRoot
            oldRoot = pRoot
        }

        if (largestValueAt[newRoot] < largestValueAt[oldRoot])
            largestValueAt[newRoot] = largestValueAt[oldRoot]
    }
}
