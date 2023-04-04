package ru.faang.school.hashmap.task_5.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

  private static Map<String, Set<WebPage>> index = new HashMap<>();

  public static List<WebPage> findWebPages(String keyword) {
    return index.getOrDefault(keyword.trim(), new HashSet<>()).stream().toList();
  }

  public static void indexesWebPage(WebPage webPage) {
    if (webPage != null) {
      if (webPage.getContent() != null) {
        Arrays.stream(webPage.getContent()
            .replaceAll("\\d", "")
            .replaceAll("\\s+", " ")
            .split(" ")).forEach(word -> {
              if(!word.isBlank() && word.trim().length() > 1) {
                var pages = index.getOrDefault(word.trim(), new HashSet<>());
                pages.add(webPage);
                index.put(word, pages);
              }
            });
      }
    }
  }

  public static void deleteWebPage(String url) {
    index.forEach((key,value) -> {
        value.remove(new WebPage(url,null,null));
    });
  }

  public static void printIndex(){
    index.forEach((key, value)-> {
      System.out.println(key + " - " + value);
    });
  }

  public static void main(String[] args) {
    var page1 = new WebPage("https://linkedin.com", "linkedin","Рейтинг linkedin.com Рейтинг сайта помогает оценить ценность бизнеса. За последние три месяца глобальный рейтинг linkedin.com has increased from 20 to 16 с 20 до 16.");
    var page2 = new WebPage("https://reddit.com", "reddit","Рейтинг reddit.com Рейтинг этого сайта помогает оценить ценность бизнеса. За последние три месяца глобальный рейтинг reddit.com has decreased from 18 to 19 с 18 до 19.");
    var page3 = new WebPage("https://office.com", "office","Рейтинг office.com Рейтинг веб-сайта помогает оценить ценность бизнеса. За последние три месяца глобальный рейтинг office.com has increased from 25 to 20 с 25 до 20.");
    var page4 = new WebPage("https://dzen.com", "dzen","Рейтинг dzen.ru Рейтинг веб-page помогает оценить ценность бизнеса. За последние три месяца глобальный рейтинг dzen.ru has not changed с 32 до 32.");
    var page5 = new WebPage("https://netflix.com", "netflix","Рейтинг netflix.com Рейтинг site помогает оценить ценность бизнеса. За последние три месяца глобальный рейтинг netflix.com has decreased from 21 to 25 с 21 до 25.");

    System.out.println("Find 'office.com' - " + findWebPages("office.com"));

    indexesWebPage(page1);
    indexesWebPage(page2);
    indexesWebPage(page3);
    indexesWebPage(page4);
    indexesWebPage(page5);
    indexesWebPage(null);

    System.out.println("Find 'dzen.ru' - " + findWebPages("dzen.ru"));
    System.out.println("Find 'netflix.com' - " + findWebPages("netflix.com"));
    System.out.println("Find 'Рейтинг' - " + findWebPages("Рейтинг"));

    deleteWebPage("https://dzen.com");

    System.out.println("DZEN WAS DELETED");

    deleteWebPage(null);

    System.out.println("Find 'dzen.ru' - " + findWebPages("dzen.ru"));

    printIndex();

  }
}
