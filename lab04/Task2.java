package lab04;

public class Task2 {

    // Метод пошуку мінімального додатного елемента та його індексу
    public static int findMinPositiveSum(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Масив порожній");
        }

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        // Використовується цикл for-each
        for (int value : arr) {
            // нічого не робимо, але ми не маємо індексу → отже, нижче альтернативний for
        }

        // цикл for для доступу до індексу
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        if (minIndex == -1) {
            throw new IllegalArgumentException("У масиві немає додатних елементів");
        }

        return minValue + minIndex;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, -2, 5, 1, 7};   // Мінімальний додатний 1, індекс 3 → 1 + 3 = 4
        int[] arr2 = {10, 20, 30};       // Мінімальний 10, індекс 0 → 10 + 0 = 10
        int[] arr3 = {-1, -2, -3};       // немає додатних → виняток

        System.out.println("arr1 → " + findMinPositiveSum(arr1));
        System.out.println("arr2 → " + findMinPositiveSum(arr2));

        try {
            System.out.println("arr3 → " + findMinPositiveSum(arr3));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
