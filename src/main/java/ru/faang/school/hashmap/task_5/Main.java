package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	private static final Map<String, List<WebPage>> map = new HashMap<>();
	
	public static void index(WebPage page) {
		
		if (page == null)
			throw new IllegalArgumentException("Null args");
		
		String content = page.getContent();
		
		List<String> list = Arrays.asList(content.trim().toLowerCase().split("[\\W\\d]"));
		
		list.stream()
			.filter(str -> !str.isBlank() && str.length() > 2)
			.distinct()
			.forEach(str ->	map.compute(str, (k, v) -> { return ifContains(v, page); }));
	}
	
	private static List<WebPage> ifContains(List<WebPage> list, WebPage page) {
		
		if (list == null) {
			list = new ArrayList<>();
		}
		
		if(!list.contains(page)) {
			list.add(page);
		}
		
        return list;
	}
	
	public static List<WebPage> getPages(String keyword) {
		
		if (keyword == null) {
			throw new IllegalArgumentException("Null args");
		}
			
		return map.get(keyword);
	}
	
	public static void removePage(String url) {
		if (url == null) {
			throw new IllegalArgumentException("Null args");
		}
		map.entrySet().forEach(e ->	e.getValue().removeIf(w -> w.getUrl().equals(url)));
		/* map.entrySet().removeIf(e -> e.getValue().isEmpty()); */  // uncomment if it needs to remove key with empty value
	}
	
	/*
	 * just for testing. pending delete.
	 */
	public static Map<String, List<WebPage>> getMap() {
		return map;
	}

	public static void main(String[] args) {
		
		String s = "I love java so much. But always I have a many questions for a different topics. "
									+ "For instance, now I try to understand a- regex66";
		
		String s2 = "But always I have a many questions for a different topics. "
				+ "For instance, now I try to understand a- Blow, newword, justfortesting";
		WebPage page = new WebPage("http://go.com", "Go page", s);
		WebPage page2 = new WebPage("http://foo.com", "Foo page", s2);
		index(page);
		index(page2);
		index(page2);
		map.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.forEach(System.out::println);
	}

}
