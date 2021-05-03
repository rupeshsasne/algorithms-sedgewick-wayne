package book.chapter1.section1

fun gcd(p: Int, q: Int): Int {
    if (q == 0) return p

    val r = p % q

    return gcd(q, r)
}

fun createRelativelyPrimeArray(n: Int): Array<Array<Boolean>> {
    val result = Array(n) { Array(n) { false } }

    result.forEachIndexed { i, booleans ->
        booleans.forEachIndexed { j, _ ->
            result[i][j] = gcd(i, j) == 1
        }
    }

    return result
}
