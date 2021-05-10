package coursera.algorithms1.week1.classroom

class UnionFind(n: Int) {
    private val ids = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    fun find(p: Int): Int {
        var curr = p

        while (ids[curr] != curr) {
            ids[curr] = ids[ids[curr]]
            curr = ids[curr]
        }

        return curr
    }

    fun union(p: Int, q: Int) {
        val pRoot = find(p)
        val qRoot = find(q)

        if (pRoot == qRoot) return

        if (size[pRoot] > size[qRoot]) {
            ids[qRoot] = pRoot
            size[pRoot] += size[qRoot]
        } else {
            ids[pRoot] = qRoot
            size[qRoot] += size[pRoot]
        }
    }
}
