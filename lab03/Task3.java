package lab03;

/**
 * Обчислює нескінченну суму Σ_{i=1..∞} 1 / i^2 з заданою точністю eps.
 * Зупинка: коли |term| < eps (тоді цей доданок не додається).
 */
public class Task3 {

    // Допоміжний клас для повернення результату + кількість ітерацій
    public static class Result {
        public final double sum;
        public final int iterations;
        public Result(double sum, int iterations) {
            this.sum = sum;
            this.iterations = iterations;
        }
    }

    public static void main(String[] args) {
        // Приклади тестів: нормальні і некоректні eps
        printResult(1e-1);      // груба точність
        printResult(1e-3);      // середня точність
        printResult(1e-8);      // висока точність
        printResult(-0.01);     // помилка: eps <= 0
        printResult(Double.NaN);// помилка: NaN
    }

    /**
     * Обчислює суму Σ 1/i^2 з заданою точністю eps.
     * Повертає об'єкт Result з сумою та кількістю доданків, які були додані.
     *
     * @param eps потрібна точність, має бути > 0
     * @return Result (sum, iterations)
     * @throws IllegalArgumentException якщо eps <= 0 або eps NaN, або якщо лічильник ітерацій перевищив MAX_ITER
     */
    public static Result calculateSum(double eps) {
        // Перевіряємо вхідний параметр
        if (Double.isNaN(eps) || eps <= 0.0) {
            throw new IllegalArgumentException("eps must be > 0; eps = " + eps);
        }

        double sum = 0.0;          // акумулятор для суми
        int i = 1;                 // індекс доданка
        final int MAX_ITER = 100_000_000; // захисний максимум ітерацій

        while (true) {
            // обчислюємо черговий член ряду: term = 1 / (i*i)
            double term = 1.0 / ( (double)i * (double)i );

            // якщо по модулю term < eps — припиняємо (цей доданок не додається)
            if (Math.abs(term) < eps) {
                break;
            }

            sum += term; // додаємо поточний доданок до суми

            i++; // переходимо до наступного індексу
            if (i > MAX_ITER) {
                // якщо не досягли умов зупинки до дуже великої кількості ітерацій
                throw new IllegalArgumentException("Required precision not reached within " + MAX_ITER + " iterations.");
            }
        }

        // i зараз вказує на перший не-доданий індекс, тому кількість доданків = i-1
        return new Result(sum, i - 1);
    }

    // Допоміжний метод для виклику calculateSum і виводу результатів
    public static void printResult(double eps) {
        try {
            Result r = calculateSum(eps);
            double analytic = Math.PI * Math.PI / 6.0; // відома точна сума ряду
            double absError = Math.abs(analytic - r.sum);

            System.out.println("eps=" + eps
                    + " -> sum=" + r.sum
                    + " iterations=" + r.iterations
                    + " analytic(pi^2/6)=" + analytic
                    + " absError=" + absError);
        } catch (IllegalArgumentException e) {
            System.out.println("eps=" + eps + " -> EXCEPTION! " + e.getMessage());
        }
    }
}
