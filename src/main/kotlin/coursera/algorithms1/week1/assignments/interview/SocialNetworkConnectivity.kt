package coursera.algorithms1.week1.assignments.interview

class SocialNetworkConnectivity(
    n: Int,
    private val allConnectedCallback: (Long) -> Unit
) {
    private val ids = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    private var connectedComponents = n

    fun union(p: Int, q: Int, timestamp: Long) {
        val pRoot = root(p)
        val qRoot = root(q)

        if (pRoot == qRoot) return

        connectedComponents--

        if (connectedComponents == 1) {
            allConnectedCallback(timestamp)
        }

        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot
            size[qRoot] += size[pRoot]
        } else {
            ids[qRoot] = pRoot
            size[pRoot] += size[qRoot]
        }
    }

    private fun root(p: Int): Int {
        var trav = p

        while (ids[trav] != trav) {
            ids[trav] = ids[ids[trav]]
            trav = ids[trav]
        }

        return trav
    }
}
