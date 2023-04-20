package acmp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.stream.IntStream;

public class ACMP82 {

    public static void main(String[] args) {
        Parserrrr parser = new Parserrrr(new DataInputStream(System.in));
        int count1 = parser.nextInt();
        int count2 = parser.nextInt();
        int[] arr1 = IntStream.range(0, count1).map(i -> parser.nextInt()).toArray();
        int[] arr2 = IntStream.range(0, count2).map(i -> parser.nextInt()).toArray();
        System.out.println(method(arr1, arr2, count1, count2));
    }

    private static String method(int[] f, int[] s, int count1, int count2) {

        int[] arr = new int[10 * 10 * 10 * 10 * 10 + 1];

        for (int i = 0; i < count1; i++) {
            if (arr[f[i]] == 0) arr[f[i]]++;
        }

        for (int i = 0; i < count2; i++) {
            if (arr[s[i]] == 1) arr[s[i]]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                sb.append(i).append(" ");
            }
        }

        return sb.toString();
    }

}

class Parserrrr {
    private static final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public Parserrrr(InputStream in) {
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
