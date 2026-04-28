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

