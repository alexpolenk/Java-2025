package lab06;

public class IntToHexString {

    public static void main(String[] args) {
        // Дозволені аргументи
        System.out.println(intToHexString(51966)); // CAFE
        System.out.println(intToHexString(255));   // FF
        System.out.println(intToHexString(0));     // 0

        // Заборонений аргумент (намагаємося перевірити обробку помилок)
        try {
            System.out.println(intToHexString(-10)); // очікуємо IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static String intToHexString(int i) {
        if (i < 0)
            throw new IllegalArgumentException("Число не може бути від'ємним");

        return Integer.toHexString(i).toUpperCase();
    }
}
