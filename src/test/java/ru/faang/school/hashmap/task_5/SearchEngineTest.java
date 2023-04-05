package ru.faang.school.hashmap.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SearchEngineTest {

    SearchEngine searchEngine;

    @BeforeEach
    void setup() {
        searchEngine = new SearchEngine();
    }

    @Test
    void testAddToCacheAndFind() {
        assertNull(searchEngine.findPages("sample"));

        WebPage webPage = new WebPage("https://test/url", "test page", "sample content");
        searchEngine.addToCache(webPage);

        assertEquals(webPage, searchEngine.findPages("sample").get(0));
        assertEquals(webPage, searchEngine.findPages("content").get(0));
    }

    @Test
    void removePage() {
        WebPage webPage = new WebPage("https://test/url", "test page", "sample content");
        searchEngine.addToCache(webPage);

        assertEquals(webPage, searchEngine.findPages("sample").get(0));

        searchEngine.removePage(webPage.url());

        assertFalse(searchEngine.findPages("sample").contains(webPage));
        assertFalse(searchEngine.findPages("content").contains(webPage));
    }
}