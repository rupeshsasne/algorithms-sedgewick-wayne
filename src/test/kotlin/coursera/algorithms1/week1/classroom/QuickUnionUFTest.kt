package coursera.algorithms1.week1.classroom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class QuickUnionUFTest {
    private val testObject = QuickUnionUF(10)

    @Test
    fun connected() {
        val random = ThreadLocalRandom.current()
        val p = random.getRandomWithExclusion(0, 9)
        val q = random.getRandomWithExclusion(0, 9, p)

        assertFalse(testObject.connected(p, q))
        testObject.union(p, q)
        assertTrue(testObject.connected(p, q))

        val r = random.getRandomWithExclusion(0, 9, p, q)
        assertFalse(testObject.connected(p, r))
        testObject.union(p, r)
        assertTrue(testObject.connected(p, r))
        assertTrue(testObject.connected(q, r))

        val s = random.getRandomWithExclusion(0, 9, p, q, r)
        assertFalse(testObject.connected(p, s))
        testObject.union(p, s)
        assertTrue(testObject.connected(p, s))
        assertTrue(testObject.connected(q, s))
        assertTrue(testObject.connected(r, s))
    }

    fun Random.getRandomWithExclusion(start: Int, end: Int, vararg exclude: Int): Int {
        var random: Int = start + nextInt(end - start + 1 - exclude.size)
        for (ex in exclude) {
            if (random < ex) {
                break
            }
            random++
        }
        return random
    }
}
