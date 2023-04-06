package ru.faang.school.hashmap.task_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task5Test {

    @Test
    public void task5Tests() {
        Main main = new Main();
        WebPage jenkins = new WebPage("www.jenkins.com", "jenkins", "The leading open source automation server");
        WebPage kafka = new WebPage("www.kafka.apache.org", "kafka", "Apache Kafka is an open source distributed event streaming leading platform");
        WebPage gitlab = new WebPage("www.gitlab.com", "gitlab", "GitLab is an open source end-to-end software development platform with built-in version control, issue tracking, code review, CI/CD, and more.");

        main.indexWebPage(jenkins);
        main.indexWebPage(kafka);
        main.indexWebPage(gitlab);

        Assertions.assertTrue(main.getWebPagesMap().get("open").contains(jenkins));
        Assertions.assertTrue(main.getWebPagesMap().get("open").contains(kafka));
        Assertions.assertTrue(main.getWebPagesMap().get("open").contains(gitlab));
        Assertions.assertFalse(main.getWebPagesMap().get("an").contains(jenkins));
        Assertions.assertTrue(main.getWebPagesMap().get("an").contains(kafka));
        Assertions.assertTrue(main.getWebPagesMap().get("an").contains(gitlab));

        Assertions.assertThrows(IllegalArgumentException.class, () -> main.indexWebPage(new WebPage("", "", "content")));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.indexWebPage(new WebPage("www.yandex.ru", "yandex", "     ")));
        Assertions.assertThrows(RuntimeException.class, () -> main.indexWebPage(new WebPage("www.yandex.ru", "yandex", ",!?#")));

        List<WebPage> foundWebPages =  main.getWebPageByKeyword("an");
        for (WebPage webPage : foundWebPages) {
            Assertions.assertTrue(webPage.getContent().contains("an"));
        }

        Assertions.assertThrows(IllegalArgumentException.class, () -> main.getWebPageByKeyword("NotValidKeyword)"));

        main.deleteWebPage("www.jenkins.com");
        Assertions.assertFalse(main.getWebPagesMap().containsValue(jenkins));
    }
}
