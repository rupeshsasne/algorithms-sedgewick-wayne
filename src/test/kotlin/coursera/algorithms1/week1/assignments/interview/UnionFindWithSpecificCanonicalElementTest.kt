package coursera.algorithms1.week1.assignments.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UnionFindWithSpecificCanonicalElementTest {
    private lateinit var uf: UnionFindWithSpecificCanonicalElement

    @Test
    fun test() {
        uf = UnionFindWithSpecificCanonicalElement(10)

        uf.union(0, 1)
        uf.union(1, 2)
        uf.union(2, 3)

        uf.union(4, 5)
        uf.union(5, 6)

        uf.union(7, 8)
        uf.union(8, 9)

        assertEquals(3, uf.find(2))
        assertEquals(6, uf.find(5))
        assertEquals(9, uf.find(7))
    }
}
