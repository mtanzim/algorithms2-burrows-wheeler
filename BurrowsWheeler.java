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

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        boolean testing = true;
        boolean debug = true;

        String t;
        int first;

        if (testing) {
            t = "ARD!RCAAAABB";
            first = 3;
        } else {
            In in = new In();
            first = in.readInt();
            t = in.readString();
        }
        if (debug) {
            StdOut.println(first);
            StdOut.println(t);
        }
        StdOut.println("INVALID");
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