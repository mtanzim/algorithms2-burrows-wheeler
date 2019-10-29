import java.util.ArrayList;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
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
                    outL.add((char) j);
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
        for (char outC : outL) {
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();
    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {
        // array of ascii chars
        char moveToFront[] = new char[256];
        // initialize
        for (int i = 0; i < 256; i++) {
            moveToFront[i] = ((char) i);
        }
        // decode
        ArrayList<Character> outL = new ArrayList<Character>();
        while (!BinaryStdIn.isEmpty()) {
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
            BinaryStdOut.write(outC);
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].compareTo("-") == 0)
            encode();
        else if (args[0].compareTo("+") == 0)
            decode();
        else
            throw new IllegalArgumentException("Not allowed");
    }

}