package coursera.algorithms1.week1.assignments.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] openGrid;

    private final WeightedQuickUnionUF percolationUf;
    private final WeightedQuickUnionUF fullUf;

    private final int n;

    private int openSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(final int n) {
        requiresPositiveNonZero(n);

        this.n = n;

        openGrid = new boolean[n][n];
        percolationUf = new WeightedQuickUnionUF((n * n) + 2);
        fullUf = new WeightedQuickUnionUF((n * n) + 2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                openGrid[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        requiresIn1ToN(row);
        requiresIn1ToN(col);

        int i = row - 1;
        int j = col - 1;

        if (openGrid[i][j]) return;

        openGrid[i][j] = true;

        openSites++;

        if (i == 0) {
            percolationUf.union(getId(i, j), 0);
            fullUf.union(getId(i, j), 0);
        }

        if (i == n - 1)
            percolationUf.union(getId(i, j), n * n + 1);

        // top
        if (i > 0 && openGrid[i - 1][j]) {
            percolationUf.union(getId(i, j), getId(i - 1, j));
            fullUf.union(getId(i, j), getId(i - 1, j));
        }

        // left
        if (j > 0 && openGrid[i][j - 1]) {
            percolationUf.union(getId(i, j), getId(i, j - 1));
            fullUf.union(getId(i, j), getId(i, j - 1));
        }

        // right
        if (j < n - 1 && openGrid[i][j + 1]) {
            percolationUf.union(getId(i, j), getId(i, j + 1));
            fullUf.union(getId(i, j), getId(i, j + 1));
        }

        // bottom
        if (i < n - 1 && openGrid[i + 1][j]) {
            percolationUf.union(getId(i, j), getId(i + 1, j));
            fullUf.union(getId(i, j), getId(i + 1, j));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        requiresIn1ToN(row);
        requiresIn1ToN(col);

        return openGrid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        requiresIn1ToN(row);
        requiresIn1ToN(col);

        return fullUf.find(0) == fullUf.find(getId(row - 1, col - 1));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolationUf.find(0) == percolationUf.find(n * n + 1);
    }

    private int getId(int row, int col) {
        return (row * n + col) + 1;
    }

    private void requiresIn1ToN(int i) {
        if (i < 1 || i > n) {
            throw new IllegalArgumentException(i + " should be in between " + 1 + " and " + n);
        }
    }

    private void requiresPositiveNonZero(int i) {
        if (i <= 0)
            throw new IllegalArgumentException(i + " should be greater than 0");
    }
}
