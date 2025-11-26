package lab06;

public class WordCounter {

    public static void main(String[] args) {
        // Дозволений:
        String s1 = "The user with the nickname koala757677 this month left 3 times more comments " +
                "than the user with the nickname croco181dile181920 4 months ago";
        System.out.println(countWords(s1)); // 19

        // Інші тести
        System.out.println(countWords("Hello world 123 abc123"));  // 4
        System.out.println(countWords("OneTwo3   9   wow77"));      // 3

        // Заборонені аргументи
        try {
            System.out.println(countWords(null)); // очікуємо NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            System.out.println(countWords("   ")); // IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static int countWords(String sentence) {
        if (sentence == null)
            throw new NullPointerException("Рядок не може бути null");

        // Видаляємо зайві пробіли
        sentence = sentence.trim();
        if (sentence.isEmpty())
            throw new IllegalArgumentException("Рядок не може бути порожнім");

        // Слова = будь-які послідовності a-z A-Z 0-9
        String[] words = sentence.split("\\s+");

        return words.length;
    }
}

