package coursera.algorithms1.week1.classroom

class QuickUnionUF(size: Int) {
    private val ids = IntArray(size) { it }

    private fun root(p: Int): Int {
        var trav = p

        while (ids[trav] != trav) {
            trav = ids[trav]
        }

        return trav
    }

    fun connected(p: Int, q: Int) =
        root(p) == root(q)

    fun union(p: Int, q: Int) {
        val pRoot = root(p)
        val qRoot = root(q)

        ids[pRoot] = qRoot
    }
}
