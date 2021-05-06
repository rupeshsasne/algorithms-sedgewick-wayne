package coursera.algorithms1.week1.assignments.interview

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SocialNetworkConnectivityTest {
    private lateinit var uf: SocialNetworkConnectivity

    @Test
    fun test() {
        var actualTimestamp: Long? = null
        uf = SocialNetworkConnectivity(10) { actualTimestamp = it }

        uf.union(0, 1, 1)
        uf.union(0, 2, 2)
        uf.union(0, 3, 3)
        uf.union(0, 4, 4)
        uf.union(4, 5, 5)
        uf.union(0, 6, 6)
        uf.union(0, 7, 7)
        uf.union(0, 8, 8)
        uf.union(1, 9, 9)
        uf.union(5, 7, 10)
        uf.union(2, 1, 11)
        uf.union(3, 8, 12)

        assertNotNull(actualTimestamp)
        assertEquals(9, actualTimestamp)
    }
}