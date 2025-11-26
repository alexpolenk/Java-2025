package lab03;

public class Task1 {

    public static void main(String[] args) {
        printResult(5, 10);   // коректно
        printResult(3, 30);   // граничний випадок
        printResult(2, 31);   // помилка (k > 30)
        printResult(0, 10);   // помилка (m = 0)
    }

    // метод для обчислення ряду
    public static double calculateSeries(int m, int k) {
        if (k <= 0 || k > 30) {
            throw new IllegalArgumentException("Invalid k: " + k);
        }
        if (m <= 0) {
            throw new IllegalArgumentException("Invalid m: " + m);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m * (1.0 / i)) * Math.sin(m * i);
        }
        return sum;
    }

    // допоміжний метод для друку
    public static void printResult(int m, int k) {
        try {
            System.out.println("m=" + m + ", k=" + k + " -> " + calculateSeries(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
