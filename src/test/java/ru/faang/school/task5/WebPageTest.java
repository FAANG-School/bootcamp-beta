package ru.faang.school.task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WebPageTest {
    Map<String, List<WebPage>> data;
    Map<String, WebPage> pages;

    @BeforeEach
    void setUp() {
        WebPage webPage = new WebPage("http://129.0.0.1/", "start", "start web page");
        WebPage webPage2 = new WebPage("http://129.0.1.1/", "java", "java backend 1");
        WebPage webPage3 = new WebPage("http://129.0.0.2/", "Go", "notJava backend");
        data = new HashMap<>();
        pages = new HashMap<>();
        WebPage.addIndexWebPage(data, webPage);
        WebPage.addIndexWebPage(data, webPage2);
        WebPage.addIndexWebPage(data, webPage3);

        pages.put("http://129.0.0.1/", webPage);
        pages.put("http://129.0.1.1/", webPage2);
        pages.put("http://129.0.0.2/", webPage3);
    }
    @Test
    void addIndexWebPage() {
        WebPage webPage = new WebPage("http://129.0.0.1/", "stat", "stat start");

        WebPage.addIndexWebPage(data, webPage);

        assertEquals(1, data.get("stat").size());
    }

    @Test
    void findWebPages() {
        List<WebPage> result = WebPage.findWebPages(data, "backend");

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void deleteIndex() {
        WebPage.deleteIndex(data, pages, "http://129.0.0.1/");

        List<WebPage> result = WebPage.findWebPages(data, "start");

        assertEquals(0, result.size());
    }
}