import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        // during testing
        // boolean debug = false;
        // String testString = "CAAABCCCACCF";
        char moveToFront[] = new char[256];

        // initialize
        for (int i = 0; i < 256; i++) {
            moveToFront[i] = ((char) i);
        }
        ArrayList<Character> outL = new ArrayList<Character>();
        while (!BinaryStdIn.isEmpty()) {
            char curChar = BinaryStdIn.readChar();
            for (int j = 0; j < moveToFront.length; j++) {
                if (curChar == moveToFront[j]) {
                    // out[i] = j;
                    outL.add((char)j);
                    // move jth character to the front
                    // shift everything else
                    for (int k = j; k > 0; k--) {
                        moveToFront[k] = moveToFront[k - 1];
                    }
                    moveToFront[0] = curChar;
                    break;

                }
            }
        }
        // if (debug) {
        //     StdOut.println(Arrays.toString(in));
        //     StdOut.println(Arrays.toString(outL.toArray()));
        //     for (int i = 0; i < outL.size(); i++) {
        //         StdOut.print(moveToFront[i]);
        //     }
        //     StdOut.println();
        // }
        for (char outC : outL) {
            // StdOut.print(outC);
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();

    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {
        // boolean debug = true;
        // boolean testing = false;
        // int testSeq[] = new int[] { 77, 89, 34, 79, 68, 4, 72, 4, 76, 84, 2, 78, 111, 111, 99, 115, 45, 0, 0, 0 };

        // int in[] = new int[500];
        // char out[] = new char[500];

        // array of ascii chars
        char moveToFront[] = new char[256];
        // initialize
        for (int i = 0; i < 256; i++) {
            moveToFront[i] = ((char) i);
        }

        // if (testing) {
        //     in = testSeq;
        //     out = new char[in.length];
        // }

        // decode
        ArrayList<Character> outL = new ArrayList<Character>();
        while (!BinaryStdIn.isEmpty()) {
        // for (int i = 0; i < in.length; i++) {
            int curIdx = (int) BinaryStdIn.readChar();
            char curChar = moveToFront[curIdx];
            outL.add(curChar);
            // move jth character to the front
            // shift everything else
            for (int k = curIdx; k > 0; k--) {
                moveToFront[k] = moveToFront[k - 1];
            }
            moveToFront[0] = curChar;

        }
        for (char outC : outL) {
            // StdOut.print(outC);
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();
        // if (debug) {
        //     StdOut.println(Arrays.toString(in));
        //     StdOut.println(Arrays.toString(out));
        //     for (int i = 0; i < in.length; i++) {
        //         StdOut.print(moveToFront[i]);
        //     }
        //     StdOut.println();
        // }
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {

        boolean debug = false;
        boolean testing = false;

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