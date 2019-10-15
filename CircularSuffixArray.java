/* *****************************************************************************
 *  Name: CircularSuffixArray.java
 *  Date: Oct 15, 2019
 *  Description: CircularSuffixArray for BW transform
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // circular suffix array of s
    public CircularSuffixArray(String s) {
    }

    // length of s
    public int length() {
        return 0;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        return 0;
    }

    // unit testing (required)
    public static void main(String[] args) {
        boolean debug = true;
        In in = new In(args[0]);
        String dictionary = in.readAll();
        if (debug) StdOut.println(dictionary.toString());
    }
}
