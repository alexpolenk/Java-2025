package lab03;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть t: ");
        double t = sc.nextDouble();

        System.out.print("Введіть i: ");
        int i = sc.nextInt();

        double x;

        if (i == 1) {
            x = Math.sqrt(t);
        } else if (i == 2) {
            x = 1 / Math.sqrt(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += k * t;
            }
            x = sum;
        }

        System.out.println("Результат x(t,i) = " + x);
    }
}

