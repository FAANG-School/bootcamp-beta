package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, List<WebPage>> indexMap = new HashMap<>();



    // 1. Метод для индексирования новой веб-страницы.
    public void indexWebPage(WebPage webPage) {
        // Разбиваем содержимое страницы на слова
        String[] words = webPage.getContent().split("\\s+");

        // Проходимся по каждому слову и добавляем страницу в HashMap
        for (String word : words) {
            List<WebPage> webPages = indexMap.get(word);
            if (webPages == null) {
                webPages = new ArrayList<>();
                indexMap.put(word, webPages);
            }
            webPages.add(webPage);
        }
    }
    // 2. Метод поиска веб-страниц по ключевому слову.
    public List<WebPage> search(String keyword) {
        List<WebPage> result = new ArrayList<>();
        if (indexMap.containsKey(keyword)) {
            result.addAll(indexMap.get(keyword));
        }
        return result;
    }
    // 3. Метод для удаления веб-страницы из индекса по её URL
    public void removeWebPage(String url) {
        for (var webPages : indexMap.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        Main searchTest = new Main();

        WebPage webPage1 = new WebPage("https://www.baeldung.com/java", "java", "Java statements are instructions that tell the programming language what to do, like declaration and string statements. Basic statements define variables and initiate Java methods or start the execution of blocks of other statements.");
        WebPage webPage2 = new WebPage("https://www.geeksforgeeks.org/python", "Page 2", "There are mainly four types of statements in Python , print statements, Assignment statements, Conditional statements, Looping statements. The print and assignment statements are commonly used in Python . The result of a print statement is a value.");
        WebPage webPage3 = new WebPage("https://www.codecademy.com/c-sharp", "Page 3", "C# has the following conditional statements: Use if to specify a block of code to be executed, if a specified condition is true. Use else to specify a block of code to be executed, if the same condition is false. Use else if to specify a new condition to test, if the first condition is false.");


        searchTest.indexWebPage(webPage1);
        searchTest.indexWebPage(webPage2);
        searchTest.indexWebPage(webPage3);

        System.out.println(searchTest.search("statements"));
        System.out.println(searchTest.search("Java"));
        System.out.println(searchTest.search("Python"));
        System.out.println(searchTest.search("Go"));

        searchTest.removeWebPage("https://www.baeldung.com/java");

        System.out.println(searchTest.search("statements"));
        System.out.println(searchTest.search("Python"));
        System.out.println(searchTest.search("Java"));
    }
}
