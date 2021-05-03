package book.chapter1.section1

fun fibRecursive(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    return fibRecursive(n - 1) + fibRecursive(n - 2)
}

fun fibIterative(n: Int): Int {
    val array = IntArray(n + 1)
    array[0] = 0
    array[1] = 1

    for (i in 2..array.lastIndex) {
        array[i] = array[i - 1] + array[i - 2]
    }

    return array[n]
}
