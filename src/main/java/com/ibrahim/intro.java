package com.ibrahim;

public class intro {

    public static void main(String[] args) {

        int n = 10000;

        measure("O(1) Constant", () -> constantExample(n));

        measure("O(n) Sum Iterative", () -> sumIterative(n));
        measure("O(n) Sum Recursive", () -> sumRecursive(n));

        measure("O(n^2) Double Loop", () -> doubleLoop(n / 100));
        measure("O(n^2) Sum of Squares", () -> sumOfSquares(n / 10));

        measure("O(n^3) Triple Loop", () -> tripleLoop(200));

        measure("O(log n) Recursive Halving", () -> logRecursive(n));

        measure("O(2^n) Fibonacci Recursive", () -> fibonacciRecursive(35));
        measure("O(n) Fibonacci Iterative", () -> fibonacciIterative(35));

        measure("O(n) Factorial Recursive", () -> factorialRecursive(15));
        measure("O(n) Factorial Iterative", () -> factorialIterative(15));
    }

    /*
     * measure metodu
     * Algoritmanın çalışma süresini nano saniye cinsinden ölçer.
     * Zaman Karmaşıklığı: O(1)
     */
    public static void measure(String name, Runnable algorithm) {
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        System.out.println(name + " -> Time: " + (end - start) + " ns");
    }

    /*
     * constantExample
     * Sadece tek bir çarpma işlemi yapar.
     * Zaman Karmaşıklığı: O(1)
     */
    public static void constantExample(int n) {
        int x = n * 2;
    }

    /*
     * sumIterative
     * 1'den n'e kadar tek döngü çalışır.
     * Toplam n adım çalışır.
     * Zaman Karmaşıklığı: O(n)
     */
    public static long sumIterative(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }

    /*
     * sumRecursive
     * Bağıntı: T(n) = T(n-1) + O(1)
     * Her çağrıda n bir azalır ve toplamda n kez çağrı yapılır.
     * Zaman Karmaşıklığı: O(n)

     */
    public static long sumRecursive(int n) {
        if (n == 0) return 0;
        return n + sumRecursive(n - 1);
    }

    /*
     * doubleLoop
     * İki iç içe döngü vardır.
     * Her biri n kez çalışır.
     * Toplam işlem sayısı n * n = n²
     * Zaman Karmaşıklığı: O(n^2)

     */
    public static void doubleLoop(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                count++;
    }

    /*
     * sumOfSquares
     * İki iç içe döngü kullanılır.
     * Toplam işlem sayısı n² kadardır.
     * Zaman Karmaşıklığı: O(n^2)

     */
    public static long sumOfSquares(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                sum += i * j;
        return sum;
    }

    /*
     * tripleLoop
     * Üç iç içe döngü vardır.
     * Toplam işlem sayısı n * n * n = n³
     * Zaman Karmaşıklığı: O(n^3)
     */
    public static void tripleLoop(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    count++;
    }

    /*
     * logRecursive
     * Bağıntı: T(n) = T(n/2) + O(1)
     * Her adımda problem boyutu yarıya düşer.
     * Yaklaşık log₂(n) adım çalışır.
     * Zaman Karmaşıklığı: O(log n)

     */
    public static int logRecursive(int n) {
        if (n <= 1) return 1;
        return 1 + logRecursive(n / 2);
    }

    /*
     * fibonacciRecursive
     * Bağıntı: T(n) = T(n-1) + T(n-2) + O(1)
     * Her çağrı iki yeni çağrı üretir.
     * Üstel büyüme oluşur.
     * Zaman Karmaşıklığı: O(2^n)

     */
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /*
     * fibonacciIterative
     * 2'den n'e kadar tek döngü çalışır.
     * Zaman Karmaşıklığı: O(n)

     */
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /*
     * factorialRecursive
     * Bağıntı: T(n) = T(n-1) + O(1)
     * Her çağrı tek bir alt çağrı üretir.
     * Toplam n kez çağrı yapılır.
     * Zaman Karmaşıklığı: O(n)

     */
    public static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    /*
     * factorialIterative
     * 2'den n'e kadar tek döngü çalışır.
     * Zaman Karmaşıklığı: O(n)

     */
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
}