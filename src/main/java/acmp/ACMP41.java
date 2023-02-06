package acmp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ACMP41 {
    public static void main(String[] args) throws IOException {
        Parserrr parser = new Parserrr(new DataInputStream(System.in));
        int count = parser.nextInt();
        int[] arr = IntStream.range(0, count).map(i -> parser.nextInt()).toArray();
        System.out.println(solve(arr));
    }

    public static String solve(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int j : arr) {
            map.merge(j, 1, Integer::sum);
//            map.compute(j, (k, v) -> (v == null) ? 1 : v + 1);
//            map.compute(j, (k, v) -> v++); // NPE
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        return sb.toString();
    }

}

class Parserrr {
    private static final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public Parserrr(InputStream in) {
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
