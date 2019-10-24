/* *****************************************************************************
 *  Name: CircularSuffixArray.java
 *  Date: Oct 15, 2019
 *  Description: CircularSuffixArray for BW transform
 **************************************************************************** */

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    private int len;
    private CircularSuffix[] suffixes;

    class CircularSuffix implements Comparable<CircularSuffix> {
        int id;
        String value;

        public CircularSuffix(int id, String value) {
            this.id = id;
            this.value = value;

        }

        public int compareTo(CircularSuffix that) {
            return value.compareTo(that.value);
        }

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        boolean debug = false;
        len = s.length();
        suffixes = new CircularSuffix[len];

        for (int i = 0; i < len; i++) {
            String sliceA = s.substring(i, s.length());
            String sliceB = s.substring(0, i);
            suffixes[i] = new CircularSuffix(i, sliceA + sliceB);
        }
        Arrays.sort(suffixes);
        if (debug) {
            for (int i = 0; i < len; i++) {
                StdOut.println(suffixes[i].getId() + ":" + suffixes[i].value);
            }
        }

    }

    // length of s
    public int length() {
        return len;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        return suffixes[i].getId();
    }

    // unit testing (required)
    public static void main(String[] args) {
        In in = new In(args[0]);
        String inputS = in.readAll();
        CircularSuffixArray sa = new CircularSuffixArray(inputS);
        int len = sa.length();
        for (int i = 0; i < len; i++) {
            StdOut.println(sa.index(i));
        }
    }
}
