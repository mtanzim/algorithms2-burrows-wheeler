import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        // during testing
        boolean debug = true;
        boolean testing = true;
        // String testString = "CAAABCCCACCF";
        String testString = "MY NAME IS Jonas!!!!";

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
                    break;

                }
            }
        }
        if (debug) {
            StdOut.println(Arrays.toString(in));
            StdOut.println(Arrays.toString(out));
            for (int i = 0; i < in.length; i++) {
                StdOut.print(moveToFront[i]);
            }
            StdOut.println();
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
            in = new int[] { 77, 89, 34, 79, 68, 4, 72, 4, 76, 84, 2, 78, 111, 111, 99, 115, 45, 0, 0, 0 };
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
            for (int i = 0; i < in.length; i++) {
                StdOut.print(moveToFront[i]);
            }
            StdOut.println();
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