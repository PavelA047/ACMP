package acmp;

import java.io.*;
import java.util.stream.IntStream;

class ACMP38_2 {
    public static void main(String[] args) {
        Parserr parser = new Parserr(new DataInputStream(System.in));
        int count = parser.nextInt();
        int[] arr = IntStream.range(0, count).map(i -> parser.nextInt()).toArray();

        System.out.println(method(arr));
    }

    private static int method(int[] numbers) {
        int result = step(numbers, 0, numbers.length - 1, Player.FIRST);
        if (result > 0)
            return 1;
        else if (result < 0)
            return 2;
        else
            return 0;
    }

    private static Player nextPlayer(Player current) {
        return current == Player.FIRST ? Player.SECOND : Player.FIRST;
    }

    private static int get(int[] numbers, int pos, Player player) {
        if (player == Player.FIRST)
            return numbers[pos];
        return -numbers[pos];
    }

    private static int step(int[] numbers, int left, int right, Player player) {
        if (left > right)
            return 0;
        if (left == right)
            return get(numbers, left, player);
        int leftResult = step(numbers, left + 1, right, nextPlayer(player)) + get(numbers, left, player);
        int rightResult = step(numbers, left, right - 1, nextPlayer(player)) + get(numbers, right, player);
        if (player == Player.FIRST) {
            return Math.max(leftResult, rightResult);
        }
        return Math.min(leftResult, rightResult);
    }

}

enum Player {
    FIRST, SECOND;
}

class Parserr {
    private static final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public Parserr(InputStream in) {
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
