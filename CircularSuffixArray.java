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
        boolean debug = true;
        if (debug)
            StdOut.println(s);
            StdOut.println(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (debug) {
                String sliceA = s.substring(i, s.length());
                String sliceB = s.substring(0, i);
                StdOut.println(sliceA+sliceB);
            }
        }

        
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
        In in = new In(args[0]);
        String inputS = in.readAll();
        CircularSuffixArray sa = new CircularSuffixArray(inputS);
        sa.length();
    }
}
