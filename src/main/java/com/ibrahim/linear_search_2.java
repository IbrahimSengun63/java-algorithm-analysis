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

import java.util.*;

public class linear_search_2 {

    static class Student {
        int id;
        String name;
        int number;
        String department;
        double grade;
        boolean isActive;

        public Student(int id, String name, int number, String department, double grade, boolean isActive) {
            this.id = id;
            this.name = name;
            this.number = number;
            this.department = department;
            this.grade = grade;
            this.isActive = isActive;
        }
    }

    public static void main(String[] args) {

        Student[][] testData = generateTestData();

        System.out.println("Veri Boyutu | ID Search | Department Search | Grade Search | Department+Active Search | Number Exists");
        System.out.println("------------------------------------------------------------------------------------------------------");

        for (Student[] students : testData) {

            /*
             * Aranan değerlerin bir kısmı son elemana yakın seçildi.
             * Böylece Linear Search daha fazla eleman kontrol etmek zorunda kalır.
             */
            int targetId = students[students.length - 1].id;
            String targetDepartment = "Computer Engineering";
            double targetGrade = 80.0;
            String activeDepartment = "Software Engineering";
            int targetNumber = students[students.length - 1].number;

            long startId = System.nanoTime();
            Student foundById = linearSearchById(students, targetId);
            long endId = System.nanoTime();

            long startDepartment = System.nanoTime();
            Student foundByDepartment = linearSearchByDepartment(students, targetDepartment);
            long endDepartment = System.nanoTime();

            long startGrade = System.nanoTime();
            Student foundByGrade = linearSearchByMinimumGrade(students, targetGrade);
            long endGrade = System.nanoTime();

            long startActiveDepartment = System.nanoTime();
            Student foundByDepartmentAndActive = linearSearchByDepartmentAndActive(students, activeDepartment);
            long endActiveDepartment = System.nanoTime();

            long startNumber = System.nanoTime();
            boolean numberExists = linearSearchNumberExists(students, targetNumber);
            long endNumber = System.nanoTime();

            System.out.printf("%12d | %9d | %17d | %12d | %24d | %13d\n",
                    students.length,
                    endId - startId,
                    endDepartment - startDepartment,
                    endGrade - startGrade,
                    endActiveDepartment - startActiveDepartment,
                    endNumber - startNumber);
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
                int number = random.nextInt(90000) + 10000;
                String department = generateRandomDepartment(random);
                double grade = 40 + random.nextDouble() * 60;
                boolean isActive = random.nextBoolean();

                data[i][j] = new Student(id, name, number, department, grade, isActive);
            }
        }

        return data;
    }

    public static String generateRandomName(Random random) {

        String[] names = {
                "Ali", "Veli", "Ayse", "Fatma", "Mehmet",
                "Ahmet", "Zeynep", "Elif", "Can", "Deniz",
                "Mert", "Ece", "Yusuf", "Selin", "Kemal"
        };

        return names[random.nextInt(names.length)];
    }

    public static String generateRandomDepartment(Random random) {

        String[] departments = {
                "Computer Engineering",
                "Software Engineering",
                "Electrical Engineering",
                "Civil Engineering",
                "Mechanical Engineering"
        };

        return departments[random.nextInt(departments.length)];
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
    // O(N) LINEAR SEARCH BY DEPARTMENT
    // -----------------------------
    public static Student linearSearchByDepartment(Student[] students, String targetDepartment) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].department.equals(targetDepartment)) {
                return students[i];
            }
        }

        return null;
    }

    // -----------------------------
    // O(N) LINEAR SEARCH BY MINIMUM GRADE
    // -----------------------------
    public static Student linearSearchByMinimumGrade(Student[] students, double minimumGrade) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].grade >= minimumGrade) {
                return students[i];
            }
        }

        return null;
    }

    // -----------------------------
    // O(N) LINEAR SEARCH BY DEPARTMENT AND ACTIVE STATUS
    // -----------------------------
    public static Student linearSearchByDepartmentAndActive(Student[] students, String targetDepartment) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].department.equals(targetDepartment) && students[i].isActive) {
                return students[i];
            }
        }

        return null;
    }

    // -----------------------------
    // O(N) LINEAR SEARCH NUMBER EXISTS
    // -----------------------------
    public static boolean linearSearchNumberExists(Student[] students, int targetNumber) {

        for (int i = 0; i < students.length; i++) {

            if (students[i].number == targetNumber) {
                return true;
            }
        }

        return false;
    }
}