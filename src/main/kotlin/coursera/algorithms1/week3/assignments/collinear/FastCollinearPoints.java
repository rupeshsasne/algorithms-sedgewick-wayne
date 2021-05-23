package coursera.algorithms1.week3.assignments.collinear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private final LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points) {
        // region prerequisites
        Utils.requireNonNull(points);
        Utils.requireNonNullItems(points);
        Utils.requireUniqueItems(points);
        // endregion

        List<LineSegment> list = new ArrayList<>();

        points = Arrays.copyOf(points, points.length);
        Arrays.sort(points);

        for (Point refPoint : points) {
            Point[] copy = Arrays.copyOf(points, points.length);
            Arrays.sort(copy, refPoint.slopeOrder());

            int j = 1;

            while (j < copy.length) {
                double refSlope = copy[j].slopeTo(refPoint);
                int lastIndex = lastIndexOfSlope(copy, j, copy.length - 1, refSlope, refPoint);

                if (lastIndex - j >= 2 && refPoint.compareTo(copy[j]) < 0) {
                    list.add(new LineSegment(refPoint, copy[lastIndex]));
                }

                j = lastIndex + 1;
            }
        }

        lineSegments = list.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(lineSegments, lineSegments.length);
    }

    private int lastIndexOfSlope(Point[] arr, int lo, int hi, double key, Point ref) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;

        int cmp = Double.compare(key, arr[mid].slopeTo(ref));

        if ((mid == arr.length - 1) || (cmp == 0
                && Double.compare(key, arr[mid + 1].slopeTo(ref)) < 0)) {
            return mid;
        } else if (cmp < 0) {
            return lastIndexOfSlope(arr, lo, mid - 1, key, ref);
        } else {
            return lastIndexOfSlope(arr, mid + 1, hi, key, ref);
        }
    }
}
