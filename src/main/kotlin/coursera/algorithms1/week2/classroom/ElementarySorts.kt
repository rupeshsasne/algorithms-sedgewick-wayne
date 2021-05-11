package coursera.algorithms1.week2.classroom

fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun <T> Array<T>.selectionSort(comparator: Comparator<T>) {
    for (i in 0..lastIndex) {
        var minIndex = i

        for (j in i..lastIndex) {
            if (comparator.compare(this[minIndex], this[j]) > 0) {
                minIndex = j
            }
        }

        swap(i, minIndex)
    }
}

fun main() {
    val array = arrayOf(10, 6, 3, 7, 9, 1, 0, 2, 4, 5)

    array.selectionSort { t1, t2 -> t1 - t2 }

    println(array.joinToString())
}
