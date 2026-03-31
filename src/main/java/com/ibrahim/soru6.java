package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
kaç tane ardışık sayı çifti vardır ki
iki eleman farkı tam olarak 1'dir?

Örnek: [3,4,2,5] → (3,4),(4,5) → sonuç = 2

İki algoritma uygulanacaktır:

1) O(N^2):
   - Tüm ardışık çiftler kontrol edilir

2) O(N):
   - Tek geçişte sadece yan yana elemanlar kontrol edilir
*/

import java.util.Random;

public class soru6 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int fastResult = linearAdjacentDiffOne(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = quadraticAdjacentDiffOne(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    // O(N)
    public static int linearAdjacentDiffOne(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (Math.abs(array[i + 1] - array[i]) == 1) {
                count++;
            }
        }

        return count;
    }

    // O(N^2)
    public static int quadraticAdjacentDiffOne(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[j] - array[i]) == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}