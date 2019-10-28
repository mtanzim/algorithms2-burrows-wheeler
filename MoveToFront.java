import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        boolean debug = true;
        boolean testing = true;
        // during testing
        char in[] = new char[500];
        // array of ascii chars
        char moveToFront[] = new char[256];
        
        for (int i=0; i < 256; i++) {
            moveToFront[i]= ((char) i);
        }


        if (testing) {
            in = "CAAABCCCACCF".toCharArray();
            if (debug) {
                StdOut.println(Arrays.toString(in));
                // StdOut.println(Arrays.toString(moveToFront));
                for (int i =65; i < 91; i++) {
                    StdOut.println(moveToFront[i]);
                }
            }
        }



    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {

    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {

        boolean debug = false;
        boolean testing = true;

        if (testing) {
            encode();
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