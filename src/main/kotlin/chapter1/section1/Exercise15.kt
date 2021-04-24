package chapter1.section1

fun histogram(a: IntArray, m: Int): IntArray {
    val result = IntArray(m)

    a.forEach { data ->
        if (data < m)
            result[data]++
    }

    return result
}
