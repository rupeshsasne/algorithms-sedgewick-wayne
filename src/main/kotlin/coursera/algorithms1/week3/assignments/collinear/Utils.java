package coursera.algorithms1.week3.assignments.collinear;

public class Utils {
    static <T> void requireNonNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
    }

    static void requireNonNullItems(Point[] arr) {
        for (Point point : arr) {
            requireNonNull(point);
        }
    }

    static void requireUniqueItems(Point[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) == 0) {
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }
}
