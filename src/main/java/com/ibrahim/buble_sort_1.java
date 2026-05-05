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
Sonra bu nesneleri her alanına göre ayrı ayrı Bubble Sort ile sıralamak:
1) id'ye göre
2) name'e göre
3) number'a göre

Her veri boyutu için sıralama süreleri karşılaştırılır.

Algoritma:

Bubble Sort:
- O(N^2)
- Komşu elemanları karşılaştırır
- Gerekirse yer değiştirir
*/

import java.util.*;

public class buble_sort_1 {

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

        System.out.println("Veri Boyutu | ID Sort Süre (ns) | Name Sort Süre (ns) | Number Sort Süre (ns)");
        System.out.println("-------------------------------------------------------------------------");

        for (Student[] students : testData) {

            Student[] idData = copyArray(students);
            Student[] nameData = copyArray(students);
            Student[] numberData = copyArray(students);

            long startId = System.nanoTime();
            bubbleSortById(idData);
            long endId = System.nanoTime();

            long startName = System.nanoTime();
            bubbleSortByName(nameData);
            long endName = System.nanoTime();

            long startNumber = System.nanoTime();
            bubbleSortByNumber(numberData);
            long endNumber = System.nanoTime();

            System.out.printf("%12d | %17d | %19d | %21d\n",
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
    // ARRAY COPY
    // -----------------------------
    public static Student[] copyArray(Student[] students) {

        Student[] copy = new Student[students.length];

        for (int i = 0; i < students.length; i++) {
            copy[i] = students[i];
        }

        return copy;
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
    // O(N^2) BUBBLE SORT BY NAME
    // -----------------------------
    public static void bubbleSortByName(Student[] students) {

        for (int i = 0; i < students.length - 1; i++) {

            for (int j = 0; j < students.length - i - 1; j++) {

                if (students[j].name.compareTo(students[j + 1].name) > 0) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    // -----------------------------
    // O(N^2) BUBBLE SORT BY NUMBER
    // -----------------------------
    public static void bubbleSortByNumber(Student[] students) {

        for (int i = 0; i < students.length - 1; i++) {

            for (int j = 0; j < students.length - i - 1; j++) {

                if (students[j].number > students[j + 1].number) {
                    swap(students, j, j + 1);
                }
            }
        }
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