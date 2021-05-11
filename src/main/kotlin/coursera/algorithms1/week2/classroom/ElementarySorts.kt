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

fun <T> Array<T>.insertionSort(comparator: Comparator<T>) {
    for (i in 0..lastIndex) {
        for (j in i downTo 1) {
            if (comparator.compare(this[j - 1], this[j]) > 0)
                swap(j - 1, j)
            else
                break
        }
    }
}
