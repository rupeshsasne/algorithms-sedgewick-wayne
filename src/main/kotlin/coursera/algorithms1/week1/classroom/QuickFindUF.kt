package coursera.algorithms1.week1.classroom

class QuickFindUF(size: Int) {
    private val ids = IntArray(size) { it }

    fun connected(p: Int, q: Int) = ids[p] == ids[q]

    fun union(p: Int, q: Int) {
        val pid = ids[p]
        val qid = ids[q]

        ids.forEachIndexed { index, value ->
            if (value == pid) {
                ids[index] = qid
            }
        }
    }
}
