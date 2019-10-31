import java.util.Arrays;
import java.util.ArrayList;
// import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

// import edu.princeton.cs.algs4.BinaryStdOut;
/**
 * BurrowsWheeler
 */
// need to use Binary StdIn, not the regular one
public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    // don't use substring before submission
    public static void transform() {
        boolean debug = false;

        // transform
        // In in = new In();
        // String inputS = in.readAll();
        String inputS = BinaryStdIn.readString();
        if (debug) {
            StdOut.println(inputS);
        }
        CircularSuffixArray sa = new CircularSuffixArray(inputS);
        int len = sa.length();
        // StringBuilder transformed = new StringBuilder();
        ArrayList<Character> transformed = new ArrayList<Character>();

        int first = -1;
        for (int i = 0; i < len; i++) {
            int curIdx = sa.index(i);
            char curString[] = new char[inputS.length()];
            int k=0;

            boolean isFirst = true;
            for (int j=curIdx; j < inputS.length(); j++) {
                curString[k]=inputS.charAt(j);
                if (isFirst && curString[k] != inputS.charAt(k)) isFirst=false;
                k++;
            }
            for (int j=0; j < curIdx; j++) {
                curString[k]=inputS.charAt(j);
                if (isFirst && curString[k] != inputS.charAt(k)) isFirst=false;
                k++;
            }
            
            // fix this, can't use substring
            // String sliceA = inputS.substring(curIdx, inputS.length());
            // String sliceB = inputS.substring(0, curIdx);
            // String curString = sliceA + sliceB;
            // StdOut.println(curString.charAt(len-1));
            // StdOut.println(Arrays.toString(curString));

            // if (Arrays.toString(curString).compareTo(inputS) == 0) {
            //     first = i;
            // }
            if (isFirst) {
                first = i;
            }
            transformed.add(curString[len-1]);
        }
        // StdOut.println(first);
        // StdOut.println(transformed);
        BinaryStdOut.write(first);
        for (char outC : transformed) {
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();
    }

    // https://www.coursera.org/lecture/algorithms-part2/key-indexed-counting-2pi1Z
    // key index counter needed to make next[]?
    // runs out of memory now
    private static int[] makeNext(char[] t, int first) {
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
        int[] next = new int[t.length];
        TNode[] tNodes = new TNode[t.length];

        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
            tNodes[i] = new TNode(t[i], i);

        }
        // need to optimize further?
        Arrays.sort(tNodes);
        for (int i = 0; i < next.length; i++) {
            next[i] = tNodes[i].getIndex();

        }
        return next;

    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        boolean testing = false;
        boolean debug = false;

        String tS;
        int first;

        // debug code
        if (testing) {
            tS = "ARD!RCAAAABB";
            first = 3;
        } else {
            // In in = new In();
            // first = in.readInt();
            // tS = in.readString();
            first = BinaryStdIn.readInt();
            tS = BinaryStdIn.readString();
        }

        char[] t = tS.toCharArray();
        char[] fc = tS.toCharArray();
        Arrays.sort(fc);
        int[] next = makeNext(t, first);
        // StringBuilder inversed = new StringBuilder();
        ArrayList<Character> inversed = new ArrayList<Character>();
        for (int i = 0; i < t.length; i++) {
            inversed.add(fc[first]);
            first = next[first];
        }

        if (debug) {
            StdOut.println("first index:\t\t" + first);
            StdOut.println("first column:\t\t" + Arrays.toString(fc));
            StdOut.println("t column:\t\t" + Arrays.toString(t));
            StdOut.println("next array:\t\t" + Arrays.toString(next));
        }
        // StdOut.println(inversed);
        for (char outC : inversed) {
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

        boolean debug = false;
        boolean testing = false;

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