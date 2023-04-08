package ru.faang.school.hashmap.task_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebPageReader {
    public static WebPage readPage(String urlString) throws IOException {
        URL url = new URL(urlString);
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine()).append("\n");
        }
        String content = stringBuilder.toString();
        String pageTitle = content.substring(content.indexOf("<title>") + 7, content.indexOf("</title>"));
        return new WebPage(url, pageTitle, content);
    }
}
