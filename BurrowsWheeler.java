import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * BurrowsWheeler
 */
public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        boolean debug = false;

        // transform
        In in = new In();
        String inputS = in.readAll();
        if (debug) {
            StdOut.println(inputS);
        }
        CircularSuffixArray sa = new CircularSuffixArray(inputS);
        int len = sa.length();
        StringBuilder transformed = new StringBuilder();
        int first = -1;
        for (int i = 0; i < len; i++) {
            int curIdx = sa.index(i);
            String sliceA = inputS.substring(curIdx, inputS.length());
            String sliceB = inputS.substring(0, curIdx);
            String curString = sliceA + sliceB;
            // StdOut.println(curString.charAt(len-1));
            if (curString.compareTo(inputS) == 0) {
                first = i;
            }
            transformed.append(curString.charAt(len - 1));
        }
        StdOut.println(first);
        StdOut.println(transformed);
    }

    // https://www.coursera.org/lecture/algorithms-part2/key-indexed-counting-2pi1Z
    // key index counter to make next[]
    private static int[] makeNext(char[] fc, char[] t, int first) {
        boolean debug = true;
        class TNode implements Comparable<TNode> {
            char value;
            int index;

            public TNode(char value, int index) {
                this.index = index;
                this.value = value;
            }

            public int compareTo(TNode that) {
                return Character.compare(value, that.value);
            }

            public int getIndex() {
                return index;
            }
        }
        int[] next = new int[fc.length];
        TNode[] tNodes = new TNode[t.length];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
            tNodes[i] = new TNode(t[i], i);

        }
        Arrays.sort(tNodes);
        for (int i = 0; i < next.length; i++) {
            next[i] = tNodes[i].getIndex();

        }
        if (debug) {
            // String fcS = new String(fc);
            // String tS = new String(t);
            StdOut.println("first index:\t\t" + first);
            StdOut.println("first column:\t\t" + Arrays.toString(fc));
            StdOut.println("t column:\t\t" + Arrays.toString(t));
            // StdOut.println("next array:\t\t" + Arrays.toString(next));
        }

        return next;

    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        boolean testing = true;
        boolean debug = true;

        String tS;
        int first;

        // debug code
        if (testing) {
            tS = "ARD!RCAAAABB";
            first = 3;
        } else {
            In in = new In();
            first = in.readInt();
            tS = in.readString();
        }

        char[] t = tS.toCharArray();
        char[] fc = tS.toCharArray();
        Arrays.sort(fc);
        int[] next = makeNext(fc, t, first);
        if (debug) {
            StdOut.println("next array:\t\t" + Arrays.toString(next));
        }
        StdOut.println("INVALID");
        // StdOut.println("INVALID");
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

        boolean debug = false;
        boolean testing = true;

        if (testing) {
            inverseTransform();
            return;
        }

        if (debug)
            StdOut.println(args[0]);
        if (args[0].compareTo("-") == 0)
            transform();
        else if (args[0].compareTo("+") == 0)
            inverseTransform();
        else
            throw new IllegalArgumentException("Not allowed");

    }

}