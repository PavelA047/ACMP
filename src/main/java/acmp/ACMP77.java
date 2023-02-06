package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ACMP77 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(method(reader.readLine()));
    }

    public static long method(String number) {
        String[] split = Optional.of(number).get().split(" ");
        long n = Long.parseLong(split[0]);
        long k = Long.parseLong(split[1]);

        if (k >= Long.toBinaryString(n).length()) return 0;

        long prevTempCount;
        long count = 0;
        long powOfTwo = 1;
        long countOfSymbolsWithoutFirst = 0;

        if (k == 0) {
            powOfTwo *= 2;
            while (n >= powOfTwo) {
                powOfTwo *= 2;
                count++;
            }
            return count;
        }

        powOfTwo *= 2;
        prevTempCount = plusCountFirstTime(countOfSymbolsWithoutFirst, k);
        count += prevTempCount;
        countOfSymbolsWithoutFirst++;

        while (n >= powOfTwo * 2) {
            powOfTwo *= 2;
            prevTempCount = plusCountThen(countOfSymbolsWithoutFirst, k, prevTempCount);
            count += prevTempCount;
            countOfSymbolsWithoutFirst++;
        }

        if ((n == powOfTwo && k == countOfSymbolsWithoutFirst) || Long.toBinaryString(n).chars().filter(x -> x == '0').count() == k) {
            count += 1;
        }

        count += cycleForTale(Long.toBinaryString(n).substring(1), k, 0);

        return count;
    }

    private static long cycleForTale(String partWithoutFirst, long k, long nullCount) {
        long count = 0;

        if (partWithoutFirst.contains("1")) {
            if (partWithoutFirst.charAt(0) == '0') {
                count += cycleForTale(partWithoutFirst.substring(1), k, ++nullCount);
                return count;
            }
            count += plusCountTail(partWithoutFirst.length() - 1, k, ++nullCount);

            nullCount -= 1;

            for (char c : partWithoutFirst.toCharArray()) {
                if (c == '0') nullCount++;
                else break;
            }

            count += cycleForTale(partWithoutFirst.chars()
                    .map(Character::getNumericValue)
                    .dropWhile(x -> x != 1)
                    .skip(1)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining("")), k, nullCount);
        }

        return count;
    }

    private static long plusCountTail(long countOfSymbolsWithoutFirst, long k, long nullCount) {
        if (k == nullCount) return 1;
        if (nullCount > k) return 0;
        k -= nullCount;
        return plusCountFirstTime(countOfSymbolsWithoutFirst, k);
    }

    private static long plusCountFirstTime(long countOfSymbolsWithoutFirst, long k) {
        if (countOfSymbolsWithoutFirst == 0 || k > countOfSymbolsWithoutFirst) return 0;
        if (k == countOfSymbolsWithoutFirst) return 1;

        BigInteger upFac = LongStream.rangeClosed(1, countOfSymbolsWithoutFirst)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        BigInteger downFacFirst = LongStream.rangeClosed(1, k)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        BigInteger downFacSecond = LongStream.rangeClosed(1, countOfSymbolsWithoutFirst - k)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        return upFac.divide(downFacFirst.multiply(downFacSecond)).intValue();
    }

    private static long plusCountThen(long countOfSymbolsWithoutFirst, long k, long prevTempCount) {
        if (countOfSymbolsWithoutFirst == 0 || k > countOfSymbolsWithoutFirst) return 0;
        if (k == countOfSymbolsWithoutFirst) return 1;

        if (prevTempCount != 0) {
            return prevTempCount * countOfSymbolsWithoutFirst / (countOfSymbolsWithoutFirst - k);
        } else return plusCountFirstTime(countOfSymbolsWithoutFirst, k);
    }

}
