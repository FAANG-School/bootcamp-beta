package ru.faang.school.hashmap.task_5;
import java.util.*;

public class Task5 {
    public static final String SPLITTER = "-----------------------------------";
    public static final String INFO_TEXT = "Выбирите действие" + "\n" + "1. - Добавить новую страницу;" + "\n" + "2. - Показать содержимое HashMap;" + "\n" + "3. - Поиск по ключевому слову в HashMap;" + "\n"+ "4. - Удалить страницу по url;" + "\n" + "0. - Выход;" + "\n" + SPLITTER;

    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);
        List<WebPage> pageList = new ArrayList<>();
        pageList.add(new WebPage("https//google.com", "google", "Google"));

        Map<String, List<WebPage>> pageMap = new HashMap<>();

        pageMap.put("google", pageList);
        while (!isExit) {
            System.out.println(INFO_TEXT);
            try {
                int value = scan.nextInt();
                System.out.println(SPLITTER);
                switch (value) {
                    case 1:
                        addNewIndexPage(pageMap);
                        break;
                    case 2:
                        getWebPageInfo(pageMap);
                        break;
                    case 3:
                        getListFromMap(pageMap);
                        break;
                    case 4:
                        removePageFromMap(pageMap);
                        break;
                    case 0:
                        System.out.println("Выход...");
                        isExit = true;
                        break;
                }
                System.out.println(SPLITTER);
            } catch (NumberFormatException nfe) {
                System.out.println("Не верный тип попробуйте еще раз");
            }
        }
    }

    public static void addNewIndexPage(Map<String, List<WebPage>> map){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите url: ");
        String urlWebPage = scan.nextLine();
        System.out.print("Введите title: ");
        String titleWebPage = scan.nextLine();
        System.out.print("Введите context: ");
        String contextWebPage = scan.nextLine();

        String[] words = contextWebPage.split(" ");
        for (String word : words) {
            WebPage pages = new WebPage(urlWebPage,titleWebPage,contextWebPage);
            map.computeIfAbsent(word, k -> new ArrayList<>()).add(pages);
        }
    }

    public static void getWebPageInfo(Map<String, List<WebPage>> map){
        for (Map.Entry maps: map.entrySet()) {
            System.out.println(maps.getKey() + " " + maps.getValue());
        }
    }

    public static void getListFromMap(Map<String, List<WebPage>> map){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ключевое слово: ");
        String keyWord = scan.nextLine();
        for (Map.Entry maps: map.entrySet()) {
            if (keyWord.equals(maps.getKey())){
                System.out.println(maps.getKey() + " " + maps.getValue());
            }
        }
    }

    public static void removePageFromMap(Map<String, List<WebPage>> map) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите url: ");
        String urlWebPage = scan.nextLine();

        for (List<WebPage> webPages : map.values()) {
            webPages.removeIf(webPage -> webPage.url.equals(urlWebPage));
        }
    }
}




class WebPage {
    public String url;
    public String title;
    public String content;

    public String getUrl() {
        return url;
    }

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebPage webPage)) return false;
        return Objects.equals(getUrl(), webPage.getUrl()) && Objects.equals(getTitle(), webPage.getTitle()) && Objects.equals(getContent(), webPage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getTitle(), getContent());
    }

    @Override
    public String toString() {
        return "url='" + url + "\', title='" + title + "\', content='" + content + "\'";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}