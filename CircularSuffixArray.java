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
    private String s;

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int id;

        public CircularSuffix(int id) {
            this.id = id;
        }

        public int compareTo(CircularSuffix that) {
            int i = id;
            int j = that.id;
            int k = 0;
            while (k < s.length()) {
                if (s.charAt(i) > s.charAt(j))
                    return 1;
                else if (s.charAt(i) < s.charAt(j))
                    return -1;
                i++;
                j++;
                k++;
                if (i == s.length())
                    i = 0;
                if (j == s.length())
                    j = 0;
            }
            return 0;
        }

        public int getId() {
            return id;
        }

    }

    // circular suffix array of s
    // can't use substring due to performance reasons (memory/time)
    // switch to converting to char array and manipulating before submission
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null string");
        }
        this.s = s;

        boolean debug = false;
        len = s.length();
        suffixes = new CircularSuffix[len];
        for (int i = 0; i < len; i++) {
            suffixes[i] = new CircularSuffix(i);
        }
        Arrays.sort(suffixes);
        if (debug) {
            for (int i = 0; i < len; i++) {
                // StdOut.println(suffixes[i].getId() + ":" + makeString(suffixes[i].id));
            }
        }

    }

    // length of s
    public int length() {
        return len;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= len) {
            throw new IllegalArgumentException("bad index");
        }
        return suffixes[i].getId();
    }

    // unit testing (required)
    public static void main(String[] args) {
        In in = new In(args[0]);
        String s = in.readAll();
        CircularSuffixArray sa = new CircularSuffixArray(s);
        int len = sa.length();
        for (int i = 0; i < len; i++) {
            StdOut.println(sa.index(i));
        }
    }
}
