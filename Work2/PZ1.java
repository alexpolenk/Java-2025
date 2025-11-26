package Work2;

public class PZ1{
    public static void main(String[] args) {
        // Значення параметрів 1
        double a = -1.49;
        double b = 23.4;
        double c = 1.23;
        double d = 2.542;

        // Формула 1: y1 = sqrt(|sin(a) - (4 * ln(b)) / (c^d)|)
        double numerator = 4 * Math.log(b);       // 4 * ln(b)
        double denominator = Math.pow(c, d);      // c^d
        double expression = Math.sin(a) - (numerator / denominator);
        double y1 = Math.sqrt(Math.abs(expression));

        //Значення параметрів 2
        double a2 = 2.34;
        double b2 = 0.756;
        double c2 = 2.23;
        double d2 = -1.653;
        // Формула 2: y2 = (e^a+3*lg(c))/sqrt(b^c)*|arctg(d)|
        double exp_a2 = Math.exp(a2);
        double Lg_c2 = Math.log10(c2);
        double numerator2 = exp_a2 + 3 * Lg_c2;
        double bc2 = Math.pow(b2, c2);
        double denom2 = Math.sqrt(bc2);
        double arctg_d2 = Math.atan(d2);
        double y2 = (numerator2 / denom2) * Math.abs(arctg_d2);

        // Значення параметрів 3
        double a3 = 1.234;
        double b3 = -3.12;
        double c3 = 5.45;
        double d3 = 2.0;

        // Формула 3: y3 = (2 * sin(a) + cos|b * sqrt(c)|)^d
        double part3 = 2.0 * Math.sin(a3) + Math.cos( Math.abs (b3 * Math.sqrt(c3)));
        double y3 = Math.pow(part3, d3);


        // Вивід результату
        System.out.println("Результат y 1 = " + y1);
        System.out.println("Результат y 2 = " + y2);
        System.out.println("Результат y 3 = " + y3);
    }
}