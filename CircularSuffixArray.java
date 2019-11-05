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

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int id;
        String value;

        public CircularSuffix(int id, char[] value) {
            this.id = id;
            this.value = new String(value);

        }

        public int compareTo(CircularSuffix that) {
            return value.compareTo(that.value);
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

        boolean debug = false;
        len = s.length();
        suffixes = new CircularSuffix[len];
        char[] curString = new char[s.length()];

        for (int i = 0; i < len; i++) {
            int k = 0;
            for (int j = i; j < s.length(); j++) {
                curString[k] = s.charAt(j);
                k++;
            }
            for (int j = 0; j < i; j++) {
                curString[k] = s.charAt(j);
                k++;
            }
            suffixes[i] = new CircularSuffix(i, curString);
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
        String s = in.readAll();
        CircularSuffixArray sa = new CircularSuffixArray(s);
        int len = sa.length();
        for (int i = 0; i < len; i++) {
            StdOut.println(sa.index(i));
        }
    }
}
