package com.ibrahim;

/*
PROBLEM:

Bir Student class'ı oluşturuluyor.
Bu class içinde:
- id
- name
- number
- department
- grade
- isActive

alanları bulunuyor.

Amaç:
Rastgele Student nesneleri üretmek.
Sonra bu nesneler içinde Linear Search kullanarak farklı aramalar yapmak:

1) id'ye göre öğrenci arama
2) department'a göre ilk öğrenciyi bulma
3) belirli bir grade değerinden yüksek ilk öğrenciyi bulma
4) hem department hem de isActive şartına uyan ilk öğrenciyi bulma
5) number'a göre var mı yok mu kontrolü yapma

Her veri boyutu için arama süreleri karşılaştırılır.

Algoritma:

Linear Search:
- O(N)
- Elemanlar baştan sona tek tek kontrol edilir
- Şartı sağlayan ilk eleman bulunduğunda arama durur
- Eleman bulunamazsa null veya false döndürülür
*/

