package com.ibrahim;

/*
PROBLEM:

Bir integer array (coin değerleri) ve hedef toplam veriliyor.

Amaç:
Minimum sayıda coin kullanarak target değere ulaşmak.

Not:
Greedy her zaman optimal çözüm vermez (genel coin sistemlerinde),
ama canonical coin sistemlerinde (1,5,10,25 gibi) doğrudur.

Algoritmalar:

1) O(N log N):
   - Greedy
   - Büyük coin'den başla, mümkün olduğunca kullan

2) O(N * target):
   - Dynamic Programming (optimal çözüm)
*/

import java.util.*;

public class soru16 {

    public static void main(String[] args) {

        int[][] testData = generateTestData();

        System.out.println("Veri Boyutu | Greedy Süre (ns) | DP Süre (ns)");
        System.out.println("------------------------------------------------");

        for (int[] coins : testData) {

            int target = coins.length * 20;

            long startGreedy = System.nanoTime();
            int greedyResult = minCoinsGreedy(coins, target);
            long endGreedy = System.nanoTime();

            long startDP = System.nanoTime();
            int dpResult = minCoinsDP(coins, target);
            long endDP = System.nanoTime();

            System.out.printf("%12d | %18d | %13d\n",
                    coins.length,
                    endGreedy - startGreedy,
                    endDP - startDP);
        }
    }

    // -----------------------------
    // TEST DATA GENERATION
    // -----------------------------
    public static int[][] generateTestData() {

        Random random = new Random();
        int[][] data = new int[4][];

        int[] sizes = {10, 20, 30, 40};

        for (int i = 0; i < sizes.length; i++) {

            Set<Integer> set = new HashSet<>();

            // coin değerleri unique olsun
            while (set.size() < sizes[i]) {
                set.add(random.nextInt(50) + 1);
            }

            data[i] = set.stream().mapToInt(Integer::intValue).toArray();
        }

        return data;
    }

    // -----------------------------
    // O(N log N) GREEDY
    // -----------------------------
    public static int minCoinsGreedy(int[] coins, int target) {

        Arrays.sort(coins);

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {

            if (coins[i] <= target) {

                int use = target / coins[i];
                count += use;
                target -= use * coins[i];
            }
        }

        return target == 0 ? count : -1;
    }

    // -----------------------------
    // O(N * target) DP (OPTIMAL)
    // -----------------------------
    public static int minCoinsDP(int[] coins, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {

            for (int coin : coins) {

                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}