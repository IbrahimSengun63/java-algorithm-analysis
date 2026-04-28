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

