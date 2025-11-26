package lab05;

public class SortByteArray {

    // Метод 1: Bubble Sort (сортування бульбашкою)
    public static void bubbleSort(byte[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // За зростанням
                    byte temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Метод 2: Selection Sort (сортування вибором)
    public static void selectionSort(byte[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            byte temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Допоміжний метод для виводу масиву
    public static void printArray(byte[] arr) {
        for (byte num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Тестування
    public static void main(String[] args) {
        byte[] data1 = {12, -4, 7, 0, 3, -8};
        byte[] data2 = data1.clone();

        System.out.println("Початковий масив:");
        printArray(data1);

        bubbleSort(data1);
        System.out.println("Після Bubble Sort (за зростанням):");
        printArray(data1);

        selectionSort(data2);
        System.out.println("Після Selection Sort (за зростанням):");
        printArray(data2);
    }
}
