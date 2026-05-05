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

