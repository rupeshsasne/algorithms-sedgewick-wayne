package coursera.algorithms1.week3.classroom

inline fun <reified T> mergeWithSmallerAux(arr: Array<T>, lo: Int, mid: Int, hi: Int, comparator: Comparator<T>) {
    val aux = Array(((hi - lo) / 2)) { arr[lo + it] }

    var i = lo
    var j = mid + 1

    var k = lo

    while (i <= mid && j <= hi) {
        if (comparator.compare(aux[i], arr[j]) > 0)
            arr[k++] = arr[j++]
        else
            arr[k++] = aux[i++]
    }

    while (i <= mid)
        arr[k++] = aux[i++]

    while (j <= hi)
        arr[k++] = arr[j++]
}

fun <T> merge(arr: Array<T>, aux: Array<T>, lo: Int, mid: Int, hi: Int, comparator: Comparator<T>) {
    for (i in lo..hi) {
        aux[i] = arr[i]
    }

    var i = lo
    var j = mid + 1

    for (k in lo..hi) {
        when {
            i > mid -> arr[k] = aux[j++]
            j > hi -> arr[k] = aux[i++]
            // keeps the sort stable.
            comparator.compare(aux[j], aux[i]) < 0 -> arr[k] = aux[j++]
            else -> arr[k] = aux[i++]
        }
    }
}

fun <T> mergeSort(arr: Array<T>, aux: Array<T>, lo: Int, hi: Int, comparator: Comparator<T>) {
    if (hi <= lo) return

    val mid = lo + (hi - lo) / 2

    mergeSort(arr, aux, lo, mid, comparator)
    mergeSort(arr, aux, mid + 1, hi, comparator)

    merge(arr, aux, lo, mid, hi, comparator)
}

inline fun <reified T> mergeSort(arr: Array<T>, comparator: Comparator<T>) {
    val aux = Array(arr.size) { arr[it] }
    mergeSort(arr, aux, 0, arr.lastIndex, comparator)
}

inline fun <reified T> mergeSortIterative(arr: Array<T>, comparator: Comparator<T>) {

    val aux = Array(arr.size) { arr[it] }
    var sz = 1

    while (sz < arr.size) {
        var lo = 0

        while (lo < arr.size - sz) {
            merge(arr, aux, lo, lo + sz - 1, (lo + sz + sz - 1).coerceAtMost(arr.lastIndex), comparator)
            lo += sz + sz
        }

        sz += sz
    }
}

fun main() {
    val arr = arrayOf(4, 5, 1, 2, 8, 9, 0, 10)
    mergeSortIterative(arr) { a, b -> a - b }
    println(arr.joinToString())
}
