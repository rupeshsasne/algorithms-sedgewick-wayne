/* *****************************************************************************
 *  Name:              Rupesh Sasne
 *  Coursera User ID:  3e29a44f1e7b650929d80a315d53eaee
 *  Last modified:     May 3, 2021
 *****************************************************************************/

package classroom.week1.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String winner = "";
        int index = 1;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (StdRandom.bernoulli(1.0d / index++)) {
                winner = word;
            }
        }

        StdOut.println(winner);
    }
}
