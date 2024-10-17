import java.util.*;

public class SynonymDictionary {
    // Используем TreeMap для автоматической сортировки ключей
    private final Map<String, LinkedHashSet<String>> dictionary = new TreeMap<>();

    // Метод для добавления термина и его синонима
    public void add(String term, String synonym) {
        // Проверяем через stream(), существует ли синоним в любом другом термине
        boolean synonymExists = dictionary.values().stream()
                .anyMatch(synonyms -> synonyms.contains(synonym));

        // Если синонима нет, добавляем его к термину
        if (!synonymExists) {
            dictionary.computeIfAbsent(term, k -> new LinkedHashSet<>()).add(synonym);
        }
    }

    // Метод для получения синонимов по термину
    public LinkedHashSet<String> get(String term) {
        return dictionary.getOrDefault(term, new LinkedHashSet<>());
    }

    // Метод для вывода всего словаря
    public void printAll() {
        // Прямой вывод entrySet в виде строки
        System.out.println(dictionary.entrySet());
    }

    public static void main(String[] args) {
        SynonymDictionary dictionary = new SynonymDictionary();

        // Добавление слов в справочник
        dictionary.add("быстрый", "скорый");
        dictionary.add("быстрый", "стремительный");
        dictionary.add("медленный", "неторопливый");
        dictionary.add("медленный", "медлительный");
        dictionary.add("умный", "интеллектуальный");
        dictionary.add("умный", "образованный");
        dictionary.add("счастливый", "радостный");
        dictionary.add("счастливый", "веселый");
        dictionary.add("красивый", "прекрасный");
        dictionary.add("красивый", "симпатичный");
        dictionary.add("грустный", "печальный");
        dictionary.add("грустный", "меланхоличный");

        // Попробуем добавить синоним, который уже существует
        dictionary.add("грустный", "образованный"); // Этот синоним уже добавлен к "умный" и не будет добавлен

        // Получение синонимов для слов
        System.out.println("Синонимы для 'быстрый': " + dictionary.get("быстрый"));
        System.out.println("Синонимы для 'счастливый': " + dictionary.get("счастливый"));
        System.out.println("Синонимы для 'грустный': " + dictionary.get("грустный"));

        // Вывод всего словаря (ключи будут отсортированы по алфавиту)
        System.out.println("\nВесь словарь:");
        dictionary.printAll();
    }
}
