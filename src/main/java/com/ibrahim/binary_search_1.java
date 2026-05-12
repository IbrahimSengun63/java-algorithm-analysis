package com.ibrahim;

/*
PROBLEM:

Bir Student class'ı oluşturuluyor.
Bu class içinde:
- id
- name
- number

alanları bulunuyor.

Amaç:
Rastgele Student nesneleri üretmek.
Sonra bu öğrenciler id değerine göre sıralanır.
Daha sonra Binary Search kullanılarak belirli bir id değerine sahip öğrenci aranır.

Her veri boyutu için Binary Search süresi ölçülür.

Algoritma:

Binary Search:
- O(log N)
- Veri sıralı olmalıdır.
- Ortadaki eleman kontrol edilir.
- Aranan değer küçükse sol tarafa gidilir.
- Aranan değer büyükse sağ tarafa gidilir.
*/

import java.util.*;

public class binary_search_1 {

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

        System.out.println("Veri Boyutu | Binary Search by ID Süre (ns)");
        System.out.println("------------------------------------------");

        for (Student[] students : testData) {

            bubbleSortById(students);

            int targetId = students[students.length - 1].id;

            long start = System.nanoTime();
            Student result = binarySearchById(students, targetId);
            long end = System.nanoTime();

            System.out.printf("%12d | %29d\n",
                    students.length,
                    end - start);
        }
    }

    // -----------------------------
    // TEST DATA GENERATION
    // -----------------------------
    public static Student[][] generateTestData() {

        Random random = new Random();
        Student[][] data = new Student[5][];

        int[] sizes = {10, 50, 100, 500, 1000};

        for (int i = 0; i < sizes.length; i++) {

            data[i] = new Student[sizes[i]];

            for (int j = 0; j < sizes[i]; j++) {

                int id = random.nextInt(10000) + 1;
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
    // O(N^2) BUBBLE SORT BY ID
    // -----------------------------
    public static void bubbleSortById(Student[] students) {

        for (int i = 0; i < students.length - 1; i++) {

            for (int j = 0; j < students.length - i - 1; j++) {

                if (students[j].id > students[j + 1].id) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    // -----------------------------
    // O(log N) BINARY SEARCH BY ID
    // -----------------------------
    public static Student binarySearchById(Student[] students, int targetId) {

        int left = 0;
        int right = students.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (students[mid].id == targetId) {
                return students[mid];
            }

            if (targetId < students[mid].id) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    // -----------------------------
    // SWAP
    // -----------------------------
    public static void swap(Student[] students, int i, int j) {

        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}