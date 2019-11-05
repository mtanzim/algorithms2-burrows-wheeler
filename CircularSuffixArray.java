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

    private String makeString(int id) {
        char[] curChar = new char[s.length()];
        int k = 0;
        for (int j = id; j < s.length(); j++) {
            curChar[k] = s.charAt(j);
            k++;
        }
        for (int j = 0; j < id; j++) {
            curChar[k] = s.charAt(j);
            k++;
        }
        return new String(curChar);
    }

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int id;

        public CircularSuffix(int id) {
            this.id = id;
        }

        public int compareTo(CircularSuffix that) {
            return makeString(id).compareTo(makeString(that.id));
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
                StdOut.println(suffixes[i].getId() + ":" + makeString(suffixes[i].id));
            }
        }

    }

    // length of s
    public int length() {
        return len;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > len) {
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
