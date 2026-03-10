package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilen tam sayılardan oluşan bir dizide
en büyük ve en küçük sayı arasındaki fark bulunacaktır.

Bu problem iki farklı algoritma ile çözülecektir:

1) O(N^2) Yavaş Algoritma:
   - Her elemanı tüm elemanlarla karşılaştırarak
     maksimum ve minimum değerleri bulur.

2) O(N) Hızlı Algoritma:
   - Tek döngü ile maksimum ve minimum değerleri bulur.


*/

import java.util.Random;

public class soru2 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            // O(N) ölçümü
            long startFast = System.nanoTime();
            int fastResult = linearMinMaxDifference(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            // O(N^2) ölçümü
            long startSlow = System.nanoTime();
            int slowResult = quadraticMinMaxDifference(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    // Rastgele veri üretimi
    public static int[] generateRandomData(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }

    // O(N) -> Tek geçişte min ve max bulma
    public static int linearMinMaxDifference(int[] array) {

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        return max - min;
    }

    // O(N^2) -> Her elemanı tüm elemanlarla karşılaştırma
    public static int quadraticMinMaxDifference(int[] array) {

        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {

            boolean isMin = true;
            boolean isMax = true;

            for (int j = 0; j < array.length; j++) {

                if (array[i] > array[j]) {
                    isMin = false;
                }

                if (array[i] < array[j]) {
                    isMax = false;
                }
            }

            if (isMin) {
                min = array[i];
            }

            if (isMax) {
                max = array[i];
            }
        }

        return max - min;
    }
}