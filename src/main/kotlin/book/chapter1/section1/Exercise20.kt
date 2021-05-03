package book.chapter1.section1

fun factorial(n: Int): Int {
    if (n <= 1) return 1
    return n * factorial(n - 1)
}
