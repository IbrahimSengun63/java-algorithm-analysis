package com.ibrahim;

/*
PROBLEM TANIMI:

Rastgele üretilmiş tam sayı dizisinde
kaç tane ardışık sayı çifti vardır ki
her ikisi de 5 ile bölünebilir?

Örnek: [5,10,6,15] → (5,10)=5 ile bölünebilir, (10,6)=hayır, (6,15)=hayır → toplam 1 çift

İki algoritma uygulanacaktır:

1) O(N^2):
   - Tüm ardışık çiftler kontrol edilir

2) O(N):
   - Tek geçişte yan yana elemanların 5 ile bölünebilirliği kontrol edilir
*/

import java.util.Random;

public class soru8 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int fastResult = linearDivisibleByFivePairs(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = quadraticDivisibleByFivePairs(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // 0..99 arası
        }

        return array;
    }

    // O(N)
    public static int linearDivisibleByFivePairs(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 5 == 0 && array[i + 1] % 5 == 0) count++;
        }

        return count;
    }

    // O(N^2)
    public static int quadraticDivisibleByFivePairs(int[] array) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= i + 1 && j < array.length; j++) {
                if (array[i] % 5 == 0 && array[j] % 5 == 0) count++;
            }
        }

        return count;
    }
}