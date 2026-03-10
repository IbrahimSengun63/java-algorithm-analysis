package com.ibrahim;

/*
 * PROBLEM TANIMI:
 * Verilen rastgele tamsayı dizisinde tekrar eden eleman var mı?

 * ALGORİTMALAR:
 *
 * 1) Hızlı algoritma -> O(N)
 *    Komşu elemanları karşılaştırarak olası tekrarları kontrol eder.
 *    (Tek geçiş)
 *
 * 2) Yavaş algoritma -> O(N^2)
 *    Tüm eleman çiftlerini karşılaştırır.
 *    (İç içe döngü)

 */

import java.util.Random;

public class soru1 {

    // Rastgele dizi üretir (tekrar olasılığını artırmak için aralık dar)
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size / 2); // tekrar ihtimali yüksek
        }
        return arr;
    }

    // O(N) — Hızlı yaklaşım (komşu kontrolü)
    public static boolean fastCheck(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // O(N^2) — Yavaş yaklaşım (tüm çiftleri kontrol)
    public static boolean slowCheck(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("VERI BOYUTU | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("--------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomArray(size);

            // ---------- O(N) ölçümü ----------
            long startFast = System.nanoTime();
            boolean fastResult = fastCheck(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            // ---------- O(N^2) ölçümü ----------
            long startSlow = System.nanoTime();
            boolean slowResult = slowCheck(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d%n",
                    size, fastTime, slowTime);


        }


    }
}