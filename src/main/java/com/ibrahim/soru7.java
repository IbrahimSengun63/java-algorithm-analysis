package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
kaç tane ardışık sayı çifti vardır ki
iki elemanın çarpımı tek sayı olsun?

Örnek:

[1,3,4,7,9] → (1,3)=tek, (3,4)=tek değil, (7,9)=tek → toplam 2 çift

İki algoritma uygulanacaktır:

1) O(N^2):
   - Tüm ardışık çiftler kontrol edilir

2) O(N):
   - Tek geçişte yan yana elemanların çarpımının tek olup olmadığı kontrol edilir
*/

import java.util.Random;

public class soru7 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int fastResult = linearOddProductPairs(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = quadraticOddProductPairs(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(50); // 0..49 arası
        }

        return array;
    }

    // O(N)
    public static int linearOddProductPairs(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] * array[i + 1]) % 2 != 0) count++;
        }

        return count;
    }

    // O(N^2)
    public static int quadraticOddProductPairs(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= i + 1 && j < array.length; j++) {
                if ((array[i] * array[j]) % 2 != 0) count++;
            }
        }

        return count;
    }
}