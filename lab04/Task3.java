package lab04;

import java.util.Arrays;

public class Task3 {

    public static int[] formArrayC(int[] A, int[] B) {
        if (A == null || B == null) {
            throw new NullPointerException("Один із масивів є null");
        }
        if (A.length != B.length) {
            throw new IndexOutOfBoundsException("Масиви мають бути однакової довжини");
        }

        int[] C = new int[A.length];
        // Використовується цикл for-each
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && B[i] > 0) {
                C[i] = A[i] + B[i];
            } else if (A[i] < 0 && B[i] < 0) {
                C[i] = A[i] * B[i];
            } else {
                C[i] = 0;
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[] A1 = {1, -2, 3, -4, 5};
        int[] B1 = {2, -3, 4, -5, -6};
        int[] A2 = {1, 2, 3};
        int[] B2 = {1, 2}; // некоректна довжина

        System.out.println("Результат C1: " + Arrays.toString(formArrayC(A1, B1)));

        try {
            System.out.println("Результат C2: " + Arrays.toString(formArrayC(A2, B2)));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}

