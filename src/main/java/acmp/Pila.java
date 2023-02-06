package acmp;

import java.io.*;
import java.util.Objects;
import java.util.stream.IntStream;

public class Pila {
    public static void main(String[] args) {
        Parser parser = new Parser(new DataInputStream(System.in));
        System.out.println(method1(parser));
    }

    public static int method1(Parser parser) {
        int count = parser.nextInt();
        int[] arr = IntStream.range(0, count).map(i -> parser.nextInt()).toArray();

        if (count == 1) return 1;
        if (count == 2) {
            if (Objects.equals(arr[0], arr[1])) {
                return 1;
            } else return 2;
        }

        int index = 0;
        int cur = arr[index];
        int prevPrev;
        int prev = cur;
        int len = 1;
        int maxLen = 1;

        for (int i = 2; i <= count; i++) {
            prevPrev = prev;
            prev = cur;
            cur = arr[++index];
            if ((prev > prevPrev && prev > cur || (prev < prevPrev && prev < cur))) {
                len++;
            } else if (prev != cur) {
                len = 2;
            } else {
                len = 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

}

class Parser {
    private static final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public Parser(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextString(int maxSize) {
        byte[] ch = new byte[maxSize];
        int point = 0;
        try {
            byte c = read();
            while (c == ' ' || c == '\n' || c == '\r')
                c = read();
            while (c != ' ' && c != '\n' && c != '\r') {
                ch[point++] = c;
                c = read();
            }
        } catch (Exception ignored) {

        }
        return new String(ch, 0, point);
    }

    public int nextInt() {
        int ret = 0;
        boolean neg;
        try {
            byte c = read();
            while (c <= ' ')
                c = read();
            neg = c == '-';
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');

            if (neg) return -ret;
        } catch (Exception ignored) {

        }
        return ret;
    }

    public long nextLong() {
        long ret = 0;
        boolean neg;
        try {
            byte c = read();
            while (c <= ' ')
                c = read();
            neg = c == '-';
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');

            if (neg) return -ret;
        } catch (Exception ignored) {

        }
        return ret;
    }

    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        } catch (Exception ignored) {

        }
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

}
