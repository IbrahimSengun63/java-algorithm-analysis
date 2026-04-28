package com.ibrahim;

/*
PROBLEM:

Bir string veriliyor.

Kural:
Eğer ardışık iki karakter aynıysa, ikisi de silinir.
Bu işlem, silinecek çift kalmayana kadar devam eder.

Amaç:
Son kalan string'i bulmak.

Örnek:
"abbaca" → "ca"

Algoritmalar:

1) O(N^2):
   - Sürekli tarama yapılarak tekrar tekrar temizleme

2) O(N):
   - Stack ile tek geçişte çözüm
*/

import java.util.Random;
import java.util.Stack;

public class soru12 {

    public static void main(String[] args) {

        String[] testData = generateTestData();

        System.out.println("Veri Boyutu | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (String data : testData) {

            long startFast = System.nanoTime();
            String fastResult = removeAdjacentOptimized(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            String slowResult = removeAdjacentBrute(data);
            long endSlow = System.nanoTime();
            long slowTime = endSlow - startSlow;

            System.out.printf("%12d | %15d | %15d\n",
                    data.length(), fastTime, slowTime);
        }
    }

    // -----------------------------
    // RANDOM STRING GENERATION
    // -----------------------------
    public static String[] generateTestData() {

        Random random = new Random();
        String[] data = new String[4];

        int[] sizes = {1000, 2000, 5000, 10000};

        for (int i = 0; i < sizes.length; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < sizes[i]; j++) {
                char c = (char) ('a' + random.nextInt(5)); // küçük alfabede yoğun tekrar
                sb.append(c);
            }

            data[i] = sb.toString();
        }

        return data;
    }

    // -----------------------------
    // O(N^2) SIMULATION (BRUTE)
    // -----------------------------
    public static String removeAdjacentBrute(String s) {

        boolean changed = true;

        while (changed) {

            changed = false;
            StringBuilder sb = new StringBuilder();

            int i = 0;

            while (i < s.length()) {

                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i += 2;
                    changed = true;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }

            s = sb.toString();
        }

        return s;
    }

    // -----------------------------
    // O(N) STACK SOLUTION
    // -----------------------------
    public static String removeAdjacentOptimized(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // ikisini de yok et
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}