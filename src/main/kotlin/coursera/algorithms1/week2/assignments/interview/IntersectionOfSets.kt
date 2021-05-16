package coursera.algorithms1.week2.assignments.interview

fun sizeOfIntersection(arr1: IntArray, arr2: IntArray): Int {
    var size = 0

    // use shell sort as per the assignment but
    arr1.sort()
    arr2.sort()

    var i = 0
    var j = 0

    while (i < arr1.size && j < arr2.size) {
        when {
            arr1[i] < arr2[j] -> i++

            arr2[j] < arr1[1] -> {
                j++
            }

            else -> {
                size++
                i++
                j++
            }
        }
    }

    return size
}
