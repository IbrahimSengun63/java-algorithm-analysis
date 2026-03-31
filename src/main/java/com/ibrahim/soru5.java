package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
art arda gelen en uzun artan alt dizinin
uzunluğunu bulun.

Örnek:

[3,5,7,2,4,6,8,1]

Artan alt diziler:

3,5,7 → uzunluk 3
2,4,6,8 → uzunluk 4

Sonuç = 4

İki algoritma uygulanacaktır:

1) O(N^2):
   - Her elemandan başlayarak
     artan seri ne kadar devam ediyor kontrol edilir

2) O(N):
   - Dizi tek geçişte taranır
   - Artış bozulduğunda sayaç sıfırlanır
*/

import java.util.Random;

public class soru5 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int fastResult = linearLongestIncreasing(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = quadraticLongestIncreasing(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }

        return array;
    }

    // O(N)
    public static int linearLongestIncreasing(int[] array) {

        int maxLength = 1;
        int current = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > array[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            if (current > maxLength) {
                maxLength = current;
            }
        }

        return maxLength;
    }

    // O(N^2)
    public static int quadraticLongestIncreasing(int[] array) {

        int maxLength = 1;

        for (int i = 0; i < array.length; i++) {

            int length = 1;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] > array[j - 1]) {
                    length++;
                } else {
                    break;
                }

            }

            if (length > maxLength) {
                maxLength = length;
            }

        }

        return maxLength;
    }
}