package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ACMP50 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String subStr = reader.readLine();
        System.out.println(method(str, subStr));
    }

    public static int method(String str, String subStr) {
        Set<String> set = new HashSet<>();
        char[] chars = subStr.toCharArray();
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars);
            if (!set.contains(s)) {
                count = findSubstr(s, str, count);
                set.add(s);
            }
            char[] newChars = new char[chars.length];
            newChars[0] = chars[chars.length - 1];
            System.arraycopy(chars, 0, newChars, 1, chars.length - 1);
            chars = newChars;
        }

        return count;
    }

    private static int findSubstr(String subStr, String str, int count) {
        char[] charsStr = str.toCharArray();
        char[] charsSubStr = subStr.toCharArray();

        for (int i = charsSubStr.length - 1; i < charsStr.length; i++) {
            boolean flag = true;
            int chSubStLastIndex = charsSubStr.length - 1;
            for (int j = i; j > i - charsSubStr.length; j--) {
                if (charsStr[i - (i - j)] != charsSubStr[chSubStLastIndex]) {
                    flag = false;
                    break;
                }
                chSubStLastIndex--;
            }
            if (flag) count++;
        }

        return count;
    }

}
