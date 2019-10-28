import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        // during testing
        boolean debug = true;
        boolean testing = true;
        String testString = "CAAABCCCACCF";

        char in[] = new char[500];
        int out[] = new int[500];

        // array of ascii chars
        char moveToFront[] = new char[256];

        // initialize
        for (int i = 0; i < 256; i++) {
            moveToFront[i] = ((char) i);
        }

        if (testing) {
            in = testString.toCharArray();
            out = new int[in.length];
        }

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < moveToFront.length; j++) {
                if (in[i] == moveToFront[j]) {
                    out[i] = j;
                    // move jth character to the front
                    // shift everything else
                    for (int k = j; k > 0; k--) {
                        moveToFront[k] = moveToFront[k - 1];
                    }
                    moveToFront[0] = in[i];

                }
            }
        }
        if (debug) {
            StdOut.println(Arrays.toString(in));
            StdOut.println(Arrays.toString(out));
            // for (int i = 0; i < in.length; i++) {
            // StdOut.println(moveToFront[i]);
            // }
        }

    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {
        boolean debug = true;
        boolean testing = true;
        int in[] = new int[500];
        char out[] = new char[500];

        // array of ascii chars
        char moveToFront[] = new char[256];

        // initialize
        for (int i = 0; i < 256; i++) {
            moveToFront[i] = ((char) i);
        }

        if (testing) {
            in = new int[] { 67, 66, 0, 0, 67, 2, 0, 0, 2, 1, 0, 70 };
            out = new char[in.length];
        }

        // decode
        for (int i = 0; i < in.length; i++) {
            out[i] = moveToFront[in[i]];

            // move jth character to the front
            // shift everything else
            for (int k = in[i]; k > 0; k--) {
                moveToFront[k] = moveToFront[k - 1];
            }
            moveToFront[0] = out[i];

        }
        if (debug) {
            StdOut.println(Arrays.toString(in));
            StdOut.println(Arrays.toString(out));
            // for (int i = 0; i < in.length; i++) {
            //     StdOut.println(moveToFront[i]);
            // }
        }
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {

        boolean debug = false;
        boolean testing = true;

        if (testing) {
            encode();
            decode();
            return;
        }
        if (debug)
            StdOut.println(args[0]);
        if (args[0].compareTo("-") == 0)
            encode();
        else if (args[0].compareTo("+") == 0)
            decode();
        else
            throw new IllegalArgumentException("Not allowed");
    }

}