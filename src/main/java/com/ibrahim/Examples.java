package com.ibrahim;

import java.util.Scanner;

public class Examples {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addNumbers(scanner);

        runAllExamples();

        scanner.close();
    }

    public static void runAllExamples() {

        checkEvenOdd(7);
        findMaxOfThree(10, 25, 15);
        calculateFactorial(5);
        checkPrime(29);

        int[] array = {4, 8, 15, 16, 23, 42};
        arrayAverage(array);
        findMaxInArray(array);

        reverseString("Java");
        countWords("Java is a powerful programming language");

        power(2, 5);

        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        matrixSum(matrix);
    }

    public static void addNumbers(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Sum: " + (a + b));
    }

    public static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static void findMaxOfThree(int a, int b, int c) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("Max number: " + max);
    }

    public static void calculateFactorial(int n) {
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorial: " + factorial);
    }

    public static void checkPrime(int n) {
        boolean isPrime = n > 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime)
            System.out.println("Prime number");
        else
            System.out.println("Not prime");
    }

    public static void arrayAverage(int[] array) {
        int sum = 0;

        for (int j : array) {
            sum += j;
        }

        double average = (double) sum / array.length;
        System.out.println("Average: " + average);
    }

    public static void findMaxInArray(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        System.out.println("Max element: " + max);
    }

    public static void reverseString(String text) {
        StringBuilder reversed = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }

        System.out.println("Reversed: " + reversed);
    }

    public static void countWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        System.out.println("Word count: " + words.length);
    }

    public static void power(int base, int exponent) {
        int result = 1;
        int i = 0;

        while (i < exponent) {
            result *= base;
            i++;
        }

        System.out.println("Result: " + result);
    }

    public static void matrixSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println("Matrix sum: " + sum);
    }
}