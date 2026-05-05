package com.ibrahim;

/*
PROBLEM:

Bir integer array ve hedef toplam veriliyor.

Amaç:
Array içinden bazı elemanları seçerek hedef toplamı elde etmek.

Algoritmalar:

1) O(2^N):
   - Backtracking
   - Her eleman için seç / seçme kararı verilir
   - currentSum > target olduğunda erken durur

2) O(2^N):
   - Brute force without bitmask
   - Tüm alt kümeler recursive olarak denenir
   - Her eleman için seç / seçme kararı verilir
*/

import java.util.*;

public class soru15 {

    public static void main(String[] args) {

        int[][] testData = generateTestData();

        System.out.println("Veri Boyutu | Backtracking Süre (ns) | Brute Force Süre (ns)");
        System.out.println("-----------------------------------------------------------");

        for (int[] data : testData) {

            int target = data.length * 25;

            long startFast = System.nanoTime();
            boolean backtrackingResult = subsetSumBacktracking(data, target, 0, 0);
            long endFast = System.nanoTime();

            long startSlow = System.nanoTime();
            boolean bruteResult = subsetSumBruteForce(data, target);
            long endSlow = System.nanoTime();

            System.out.printf("%12d | %22d | %21d\n",
                    data.length,
                    endFast - startFast,
                    endSlow - startSlow);
        }
    }

    // -----------------------------
    // TEST DATA GENERATION
    // -----------------------------
    public static int[][] generateTestData() {

        Random random = new Random();
        int[][] data = new int[4][];

        int[] sizes = {10, 15, 20, 25};

        for (int i = 0; i < sizes.length; i++) {

            data[i] = new int[sizes[i]];

            for (int j = 0; j < sizes[i]; j++) {
                data[i][j] = random.nextInt(50) + 1;
            }
        }

        return data;
    }

    // -----------------------------
    // O(2^N) BACKTRACKING
    // -----------------------------
    public static boolean subsetSumBacktracking(int[] arr,
                                                int target,
                                                int index,
                                                int currentSum) {

        if (currentSum == target) {
            return true;
        }

        if (index == arr.length || currentSum > target) {
            return false;
        }

        if (subsetSumBacktracking(arr, target,
                index + 1, currentSum + arr[index])) {
            return true;
        }

        return subsetSumBacktracking(arr, target,
                index + 1, currentSum);
    }

    // -----------------------------
    // O(2^N) BRUTE FORCE
    // -----------------------------
    public static boolean subsetSumBruteForce(int[] arr, int target) {

        return bruteForceHelper(arr, target, 0, 0);
    }

    private static boolean bruteForceHelper(int[] arr,
                                            int target,
                                            int index,
                                            int currentSum) {

        if (index == arr.length) {
            return currentSum == target;
        }

        if (bruteForceHelper(arr, target,
                index + 1, currentSum + arr[index])) {
            return true;
        }

        return bruteForceHelper(arr, target,
                index + 1, currentSum);
    }
}