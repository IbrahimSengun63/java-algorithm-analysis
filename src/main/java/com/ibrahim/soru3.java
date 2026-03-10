package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
i < j koşulunu sağlayan ve array[i] == array[j]
olan kaç indeks çifti vardır?

İki algoritma uygulanacaktır:

1) O(N^2):
   - Tüm indeks çiftleri kontrol edilir

2) O(N):
   - Frekans sayımı yapılır
   - k*(k-1)/2 formülü uygulanır

*/

import java.util.Random;

public class soru3 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            // O(N)
            long startFast = System.nanoTime();
            long fastResult = linearEqualPairs(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            // O(N^2)
            long startSlow = System.nanoTime();
            long slowResult = quadraticEqualPairs(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    // Rastgele veri üretimi (0 - 99 arası)
    public static int[] generateRandomData(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    // O(N) çözüm
    public static long linearEqualPairs(int[] array) {

        int[] frequency = new int[100];
        long count = 0;

        for (int i = 0; i < array.length; i++) {
            frequency[array[i]]++;
        }

        for (int i = 0; i < 100; i++) {
            int k = frequency[i];
            count += (long) k * (k - 1) / 2;
        }

        return count;
    }

    // O(N^2) çözüm
    public static long quadraticEqualPairs(int[] array) {

        long count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}