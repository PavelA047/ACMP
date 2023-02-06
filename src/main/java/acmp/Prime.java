package acmp;

import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        getArrayOfPrimeNumbers(100);
        getArrayOfPrimeNumbers2(100);

        // STREAM API
        IntStream.rangeClosed(1, 100)
                .filter(x -> x != 1)
                .forEach(x -> {
                    int k = 0;
                    for (int i = 1; i <= x; i++) {
                        if (x % i == 0) {
                            k++;
                        }
                    }
                    if (k == 2) {
                        System.out.print(x + " ");
                    }
                });
    }

    public static void getArrayOfPrimeNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            boolean isPrime = true;//флаг
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {//если число i не простое,
                //то хотябы один делитель будет находится в промежутке от 2 до sqrt(i)
                if ((i % j) == 0) { //Если j - делитель числа, устанавливаем флаг на false
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");//если делителей нет, то флаг не изменится
            }
        }
        System.out.println();
    }

    public static void getArrayOfPrimeNumbers2(int a) {
        for (int j = 1; j <= a; j++) {
            int k = 0;
            for (int i = 2; i <= j; i++) {
                if (j % i == 0) {
                    k++;
                }
            }
            if (k == 1) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }


//    public static void main(String[] args) {
//
//        // ITVDN.com ТОП 20 тестовых заданий на интервью для Java разработчика
//
//        int temp, number;
//
//        boolean numberIsPrime = true;
//
//        Scanner scannerQ = new Scanner(System.in);
//
//        number = scannerQ.nextInt();
//
//        scannerQ.close();
//
//        for (int x = 2; x<= number /2; x++) {
//
//            tempNumber = number %x;
//
//            if (tempNumber == 0) {
//
//                numberIsPrime = false;
//
//                break;
//
//            }
//
//        }
//
//        if(numberIsPrime)
//
//            System.out.println(number + " число является простым");
//
//        else
//
//            System.out.println(number + " число не является простым");
//
//
//
//
//
//    }

}