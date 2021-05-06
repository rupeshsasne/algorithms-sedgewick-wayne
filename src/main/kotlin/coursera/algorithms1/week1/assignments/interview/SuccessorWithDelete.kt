package coursera.algorithms1.week1.assignments.interview

class SuccessorWithDelete(private val n: Int) {
    private val uf = UnionFindWithSpecificCanonicalElement(n + 1)

    fun remove(x: Int) {
        uf.union(x, x + 1)
    }

    fun successor(x: Int): Int? {
        val successor = uf.find(x)
        return if (successor == n) null else successor
    }
}
