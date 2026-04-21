package com.ibrahim;

/*
PROBLEM:

Bir tam sayı dizisi ve k değeri veriliyor.

Amaç:
Toplamı k olan kaç adet alt dizi (subarray) vardır?

Örnek:
[1,2,3,-2,5], k = 5 → [2,3], [5] → sonuç: 2

Algoritmalar:

1) O(N^3):
   - Tüm alt diziler denenir
   - Her biri için toplam sıfırdan hesaplanır

2) O(N^2):
   - Her başlangıç noktası için sum kademeli güncellenir
*/

import java.util.Random;

public class soru9 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 5000};

        int k = 10;

        System.out.println("Veri Sayısı | O(N^2) Süre (ns) | O(N^3) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int fastResult = quadraticSubarraySum(data, k);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = cubicSubarraySum(data, k);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(20) - 10; // -10 .. +9
        }

        return array;
    }

    // O(N^2)
    public static int quadraticSubarraySum(int[] array, int k) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {

            int sum = 0;

            for (int j = i; j < array.length; j++) {
                sum += array[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // O(N^3)
    public static int cubicSubarraySum(int[] array, int k) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length; j++) {

                int sum = 0;

                for (int t = i; t <= j; t++) {
                    sum += array[t];
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}