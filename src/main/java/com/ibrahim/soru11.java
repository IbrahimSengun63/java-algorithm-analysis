package com.ibrahim;

/*
PROBLEM:

Bir string veriliyor.

Amaç:
Tekrarlayan karakter içermeyen en uzun substring uzunluğunu bulmak.

Örnek:
"abcabcbb" → 3 ("abc")

Algoritmalar:

1) O(N^2):
   - Her başlangıç için substring kontrol edilir

2) O(N):
   - Sliding window + two pointers + last seen array
*/

import java.util.Random;

public class soru11 {

    public static void main(String[] args) {

        String[] testData = generateTestData();

        System.out.println("Veri Boyutu | O(N) Süre (ns) | O(N^2) Süre (ns)");
        System.out.println("---------------------------------------------------");

        for (String data : testData) {

            long startFast = System.nanoTime();
            int fastResult = longestUniqueSubstringOptimized(data);
            long endFast = System.nanoTime();
            long fastTime = endFast - startFast;

            long startSlow = System.nanoTime();
            int slowResult = longestUniqueSubstringBrute(data);
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
                char c = (char) ('a' + random.nextInt(26));
                sb.append(c);
            }

            data[i] = sb.toString();
        }

        return data;
    }

    // -----------------------------
    // O(N^2) BRUTE FORCE
    // -----------------------------
    public static int longestUniqueSubstringBrute(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            boolean[] seen = new boolean[256];

            for (int j = i; j < n; j++) {

                char c = s.charAt(j);

                if (seen[c]) break;

                seen[c] = true;

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

    // -----------------------------
    // O(N) OPTIMIZED SLIDING WINDOW
    // -----------------------------
    public static int longestUniqueSubstringOptimized(String s) {

        int[] lastIndex = new int[256];

        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }

            lastIndex[c] = right;

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}