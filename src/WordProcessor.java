import java.util.*;

public class WordProcessor {
    public static void main(String[] args) {
        // Массив слов (с повторами)
        String[] words = {"Футбол", "Баскетбол", "Футбол", "Волейбол", "Баскетбол", "Гандбол",
                "Футбол", "Хоккей", "Волейбол", "Гандбол", "Хоккей", "Теннис", "Баскетбол"};

        // Для подсчета количества вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        // Заполняем wordCount с использованием merge
        Arrays.stream(words).forEach(word -> wordCount.merge(word, 1, Integer::sum));

        // Вывод entrySet (без циклов и foreach)
        System.out.println("Уникальные слова: " + wordCount.keySet());
        System.out.println(wordCount.entrySet());
    }
}

