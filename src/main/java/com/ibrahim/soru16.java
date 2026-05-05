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

