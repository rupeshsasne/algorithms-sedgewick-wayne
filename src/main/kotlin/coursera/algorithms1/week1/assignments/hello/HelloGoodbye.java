/* *****************************************************************************
 *  Name:              Rupesh Sasne
 *  Coursera User ID:  3e29a44f1e7b650929d80a315d53eaee
 *  Last modified:     May 3, 2021
 *****************************************************************************/

package coursera.algorithms1.week1.assignments.hello;

import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
        String string = "Hello "
                + args[0] + " and " + args[1] + "."
                + "\n"
                + "Goodbye "
                + args[1] + " and " + args[0] + ".";

        StdOut.println(string);
    }
}
