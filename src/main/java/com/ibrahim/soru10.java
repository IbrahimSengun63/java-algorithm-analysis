package com.ibrahim;

/*
PROBLEM:

Günlük sıcaklıklar dizisi veriliyor.

Her gün için:
Daha sıcak bir günün kaç gün sonra geleceğini bul.

Eğer yoksa → 0

Örnek:
[30, 40, 35, 50, 45, 60]
→ [1, 2, 1, 2, 1, 0]

Algoritmalar:

1) O(N^2):
   - Her gün için sağa bakarak daha büyük sıcaklık aranır

2) O(N):
   - Monotonic Stack kullanılır
*/

import java.util.Random;
import java.util.Stack;

public class soru10 {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("Veri Sayısı | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (int size : sizes) {

            int[] data = generateRandomData(size);

            long startFast = System.nanoTime();
            int[] fastResult = stackDailyTemperatures(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int[] slowResult = bruteForceDailyTemperatures(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%10d | %15d | %15d\n", size, fastTime, slowTime);
        }
    }

    public static int[] generateRandomData(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(70) + 30; // 30 - 100 arası sıcaklık
        }

        return array;
    }

    // O(N^2)
    public static int[] bruteForceDailyTemperatures(int[] temps) {

        int n = temps.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (temps[j] > temps[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    // O(N) - Monotonic Stack
    public static int[] stackDailyTemperatures(int[] temps) {

        int n = temps.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}