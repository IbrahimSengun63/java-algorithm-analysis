package com.ibrahim;

/*
PROBLEM:

Bir integer array veriliyor.

Amaç:
Array içindeki maksimum elemanı bulmak.

Algoritmalar:

1) O(N):
   - Basit linear scan

2) O(N):
   - Simple Divide and Conquer
   - Array ikiye bölünür
   - Sol tarafın maksimumu bulunur
   - Sağ tarafın maksimumu bulunur
   - İkisinden büyük olan cevap olur
*/

import java.util.*;

public class soru14 {

    public static void main(String[] args) {

        int[][] testData = generateTestData();

        System.out.println("Veri Boyutu | Divide-Conquer Süre (ns) | Linear Süre (ns)");
        System.out.println("----------------------------------------------------------");

        for (int[] data : testData) {

            long startFast = System.nanoTime();
            int dcResult = maxDivideConquer(data, 0, data.length - 1);
            long endFast = System.nanoTime();

            long startSlow = System.nanoTime();
            int linearResult = maxLinear(data);
            long endSlow = System.nanoTime();

            System.out.printf("%12d | %24d | %15d\n",
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

        int[] sizes = {1000, 2000, 4000, 8000};

        for (int i = 0; i < sizes.length; i++) {

            data[i] = new int[sizes[i]];

            for (int j = 0; j < sizes[i]; j++) {
                data[i][j] = random.nextInt(100000);
            }
        }

        return data;
    }

    // -----------------------------
    // O(N) LINEAR SCAN
    // -----------------------------
    public static int maxLinear(int[] arr) {

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // -----------------------------
    // O(N) SIMPLE DIVIDE AND CONQUER
    // -----------------------------
    public static int maxDivideConquer(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }

        int mid = left + (right - left) / 2;

        int leftMax = maxDivideConquer(arr, left, mid);
        int rightMax = maxDivideConquer(arr, mid + 1, right);

        return Math.max(leftMax, rightMax);
    }
}