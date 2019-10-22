import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * BurrowsWheeler
 */
public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

        // transform
        In in = new In(args[0]);
        String inputS = in.readAll();
        CircularSuffixArray sa = new CircularSuffixArray(inputS);
        int len = sa.length();
        StringBuilder encrypted = new StringBuilder();
        int first = -1;
        for (int i = 0; i < len; i++) {
            int curIdx = sa.index(i);
            String sliceA = inputS.substring(curIdx, inputS.length());
            String sliceB = inputS.substring(0, curIdx);
            String curString = sliceA+sliceB;
            // StdOut.println(curString.charAt(len-1));
            if (curString.compareTo(inputS) == 0) {
                first = i;
            }
            encrypted.append(curString.charAt(len-1));
        }
        StdOut.println(first);
        StdOut.println(encrypted);
    }

}