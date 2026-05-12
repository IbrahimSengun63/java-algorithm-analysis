package com.ibrahim;

/*
PROBLEM:

Bir Student class'ı oluşturuluyor.
Bu class içinde:
- id
- name
- number

alanları bulunuyor.


Rastgele Student nesneleri üretmek.
Sonra bu nesneler içinde Linear Search kullanarak arama yapmak:
1) id'ye göre öğrenci arama
2) name'e göre öğrenci arama
3) number'a göre öğrenci arama

Her veri boyutu için arama süreleri karşılaştırılır.

Algoritma:

Linear Search:
- O(N)
- Elemanlar baştan sona tek tek kontrol edilir
- Aranan değer bulunursa ilgili öğrenci döndürülür
- Bulunamazsa null döndürülür
*/

import java.util.*;

public class linear_search_1 {

    static class Student {
        int id;
        String name;
        int number;

        public Student(int id, String name, int number) {
            this.id = id;
            this.name = name;
            this.number = number;
        }
    }

    public static void main(String[] args) {

        Student[][] testData = generateTestData();

        System.out.println("Veri Boyutu | ID Search Süre (ns) | Name Search Süre (ns) | Number Search Süre (ns)");
        System.out.println("----------------------------------------------------------------------------");

        for (Student[] students : testData) {

            /*
             * Aranan değerler özellikle dizinin son elemanından seçildi.
             * Böylece Linear Search çoğu elemanı kontrol etmek zorunda kalır.
             */
            int targetId = students[students.length - 1].id;
            String targetName = students[students.length - 1].name;
            int targetNumber = students[students.length - 1].number;

            long startId = System.nanoTime();
            Student foundById = linearSearchById(students, targetId);
            long endId = System.nanoTime();

            long startName = System.nanoTime();
            Student foundByName = linearSearchByName(students, targetName);
            long endName = System.nanoTime();

            long startNumber = System.nanoTime();
            Student foundByNumber = linearSearchByNumber(students, targetNumber);
            long endNumber = System.nanoTime();

            System.out.printf("%12d | %20d | %22d | %24d\n",
                    students.length,
                    endId - startId,
                    endName - startName,
                    endNumber - startNumber);
        }
    }

    // -----------------------------
    // TEST DATA GENERATION
    // -----------------------------
    public static Student[][] generateTestData() {

        Random random = new Random();
        Student[][] data = new Student[4][];

        int[] sizes = {10, 20, 30, 40};

        for (int i = 0; i < sizes.length; i++) {

            data[i] = new Student[sizes[i]];

            for (int j = 0; j < sizes[i]; j++) {

                int id = random.nextInt(1000) + 1;
                String name = generateRandomName(random);
                int number = random.nextInt(5000) + 1;

                data[i][j] = new Student(id, name, number);
            }
        }

        return data;
    }

    public static String generateRandomName(Random random) {

        String[] names = {
                "Ali", "Veli", "Ayse", "Fatma", "Mehmet",
                "Ahmet", "Zeynep", "Elif", "Can", "Deniz"
        };

        return names[random.nextInt(names.length)];
    }

    // -----------------------------
    // O(N) LINEAR SEARCH BY ID
    // -----------------------------
    public static Student linearSearchById(Student[] students, int targetId) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].id == targetId) {
                return students[i];
            }
        }

        return null;
    }

    // -----------------------------
    // O(N) LINEAR SEARCH BY NAME
    // -----------------------------
    public static Student linearSearchByName(Student[] students, String targetName) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].name.equals(targetName)) {
                return students[i];
            }
        }

        return null;
    }

    // -----------------------------
    // O(N) LINEAR SEARCH BY NUMBER
    // -----------------------------
    public static Student linearSearchByNumber(Student[] students, int targetNumber) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].number == targetNumber) {
                return students[i];
            }
        }

        return null;
    }
}