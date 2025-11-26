package lab04;

public class Task1 {

    // Метод, що обчислює кількість додатних елементів
    public static int countPositive(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        int count = 0;
        // Використовується цикл for
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -2, 3, 4, -5};
        int[] arr2 = {-1, -2, -3};
        int[] arr3 = {};  // Порожній масив
        int[] arr4 = null; // Некоректний аргумент

        System.out.println("arr1 → " + countPositive(arr1)); // 3
        System.out.println("arr2 → " + countPositive(arr2)); // 0
        System.out.println("arr3 → " + countPositive(arr3)); // 0

        try {
            System.out.println("arr4 → " + countPositive(arr4)); // викличе виняток
        } catch (NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
