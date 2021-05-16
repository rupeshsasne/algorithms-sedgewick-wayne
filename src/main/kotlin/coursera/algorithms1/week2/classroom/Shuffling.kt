package coursera.algorithms1.week2.classroom

import edu.princeton.cs.algs4.StdRandom

fun <T> Array<T>.knuthShuffle() {
    for (i in 0..lastIndex) {
        val randomIndex = StdRandom.uniform(i, size)
        val temp = this[randomIndex]
        this[randomIndex] = this[i]
        this[i] = temp
    }
}

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(array.apply { knuthShuffle() }.joinToString())
}
