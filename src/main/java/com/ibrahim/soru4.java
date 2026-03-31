package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
en büyük ikinci elemanı bulun.

Örneğin:
[7, 2, 10, 5, 8] → ikinci en büyük = 8

İki algoritma uygulanacaktır:

1) O(N^2):
   - En büyük eleman bulunur
   - Sonra ikinci en büyük tekrar aranır

2) O(N):
   - Tek geçişte hem max hem secondMax tutulur
*/

import java.util.Random;

public class soru4 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            // O(N)
            long startFast = System.nanoTime();
            int fastResult = linearSecondMax(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            // O(N^2)
            long startSlow = System.nanoTime();
            int slowResult = quadraticSecondMax(data);
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
    public static int linearSecondMax(int[] array) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int value : array) {

            if (value > max) {
                secondMax = max;
                max = value;
            }
            else if (value > secondMax && value != max) {
                secondMax = value;
            }

        }

        return secondMax;
    }

    public static int quadraticSecondMax(int[] array) {
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            int countGreater = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    countGreater++;
                }
            }

            if (countGreater == 1) {
                secondMax = array[i];
                break;
            }
        }

        return secondMax;
    }
}