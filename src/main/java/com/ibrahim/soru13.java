package com.ibrahim;

/*
PROBLEM:

Bir tam sayı dizisi veriliyor.

Amaç:
Diziyi strictly increasing hale getirmek için
gereken minimum artırma maliyetini bulmak.

İşlem:
Bir elemanı 1 artırmak = 1 maliyet

Örnek:
[3, 2, 1, 2, 1, 7] → maliyet: 6 (örnek)

Algoritmalar:

1) O(N^2):
   - Sürekli düzeltme simülasyonu yapılır

2) O(N):
   - Greedy tek geçiş çözüm
*/

import java.util.Random;

public class soru13 {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000};

        System.out.println("Veri Boyutu | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data1 = generateRandomData(size);
            int[] data2 = data1.clone();

            long startFast = System.nanoTime();
            int fastResult = greedyMinCostIncreasing(data1);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = simulationMinCostIncreasing(data2);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%12d | %15d | %15d\n",
                    size, fastTime, slowTime);
        }
    }

    // -----------------------------
    // RANDOM DATA GENERATION
    // -----------------------------
    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10); // 0..9
        }

        return array;
    }

    // -----------------------------
    // O(N^2) SIMULATION APPROACH
    // -----------------------------
    public static int simulationMinCostIncreasing(int[] arr) {

        int cost = 0;
        boolean changed = true;

        while (changed) {

            changed = false;

            for (int i = 1; i < arr.length; i++) {

                if (arr[i] <= arr[i - 1]) {

                    int diff = (arr[i - 1] + 1) - arr[i];

                    cost += diff;
                    arr[i] = arr[i - 1] + 1;

                    changed = true;
                }
            }
        }

        return cost;
    }

    // -----------------------------
    // O(N) GREEDY APPROACH
    // -----------------------------
    public static int greedyMinCostIncreasing(int[] arr) {

        int cost = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] <= arr[i - 1]) {

                int diff = (arr[i - 1] + 1) - arr[i];

                cost += diff;

                arr[i] = arr[i - 1] + 1;
            }
        }

        return cost;
    }
}