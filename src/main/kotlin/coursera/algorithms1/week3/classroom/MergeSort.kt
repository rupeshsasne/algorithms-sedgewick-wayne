package coursera.algorithms1.week3.classroom

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

fun <T> sort(arr: Array<T>, aux: Array<T>, lo: Int, hi: Int, comparator: Comparator<T>) {
    if (hi <= lo) return

    val mid = lo + (hi - lo) / 2

    sort(arr, aux, lo, mid, comparator)
    sort(arr, aux, mid + 1, hi, comparator)

    merge(arr, aux, lo, mid, hi, comparator)
}

inline fun <reified T> sort(arr: Array<T>, comparator: Comparator<T>) {
    val aux = Array(arr.size) { arr[it] }
    sort(arr, aux, 0, arr.lastIndex, comparator)
}

fun main() {
    val arr = arrayOf(4, 5, 1, 2, 8, 9, 0, 10)
    sort(arr) { a, b -> a - b }
    println(arr.joinToString())
}
