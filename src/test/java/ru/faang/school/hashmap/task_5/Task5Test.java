package ru.faang.school.hashmap.task_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task5Test {
	
	private final String s1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
			+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi "
			+ "ut aliquip ex ea commodo consequat. Duis SAMEWORD aute irure dolor in reprehenderit "
			+ "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. ";
	private final String s2 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem "
			+ "accusantium doloremque laudantium, totam rem aperiam, "
			+ "eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta "
			+ "sunt explicabo. Nemo enim SAMEWORD ipsam voluptatem quia voluptas sit aspernatur aut odit "
			+ "aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.";
	private final String s3 = "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, "
			+ "consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore "
			+ "et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, "
			+ "quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex "
			+ "ea commodi SAMEWORD consequatur?";
	
	private final WebPage page1 = new WebPage("http://foo.com", "Foo", s1);
	private final WebPage page2 = new WebPage("http://baa.es", "Baa", s2);
	private final WebPage page3 = new WebPage("http://tee.com", "Tee", s3);
	
	private List<WebPage> list1;
	private List<WebPage> list2;
	private List<WebPage> list3;
	
	private final List<WebPage> listImmutable1 = List.of(page1);
	private final List<WebPage> listImmutable2 = List.of(page1, page2);
	private final List<WebPage> listImmutable3 = List.of(page1, page2, page3);
	
	private List<String> words1;
	private List<String> words2;
	private List<String> words3;
	
	@BeforeEach
	void init() {
		words1 = Arrays.asList(s1.trim().toLowerCase().split("[\\W\\d]"))
				.stream()
				.filter(str -> !str.isBlank() && str.length() > 2)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		words2 = Arrays.asList(s2.trim().toLowerCase().split("[\\W\\d]"))
				.stream()
				.filter(str -> !str.isBlank() && str.length() > 2)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		words3 = Arrays.asList(s3.trim().toLowerCase().split("[\\W\\d]"))
				.stream()
				.filter(str -> !str.isBlank() && str.length() > 2)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		list1 = new ArrayList<>(List.of(page1));
		list2 = new ArrayList<>(List.of(page1, page2));
		list3 = new ArrayList<>(List.of(page1, page2, page3));
		
	}
	
	@AfterEach
	void reset() {
		Main.getMap().clear();
		words1.clear();
		words2.clear();
		words3.clear();
		list1.clear();
		list2.clear();
		list3.clear();
	}
	
	@Test
	void indexNullArgs() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
				() -> Main.index(null));
		assertEquals("Null args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, 
				() -> Main.index(new WebPage("http://tee.com", "Tee", null)));
		assertEquals("Null agrs of WebPage", ex.getMessage());
	}
	
	@Test
	void indexAddOnePage() {
		Main.index(page1);
		
		assertEquals(words1.size(), Main.getMap().size());
		
		List<String> keys = Main.getMap().entrySet().stream()
								.map(e -> e.getKey())
								.sorted()
								.collect(Collectors.toList());
		
		assertEquals(words1, keys);
	}
	
	@Test
	void indexAddManyPages() {
		Set<String> set = new HashSet<>(words1);
		set.addAll(words2);
		set.addAll(words3);
		List<String> words = set.stream().sorted().collect(Collectors.toList());
		
		Main.index(page1);
		Main.index(page2);
		Main.index(page3);
		
		
		assertEquals(set.size(), Main.getMap().size());
		
		List<String> keys = Main.getMap().entrySet().stream()
								.map(e -> e.getKey())
								.sorted()
								.collect(Collectors.toList());
		
		assertEquals(words, keys);
	}
	
	@Test
	void getPages() {
		Main.index(page1);
		
		assertEquals(list1, Main.getPages("sameword"));
		assertEquals(list1, Main.getPages("Sameword"));
		assertEquals(list1, Main.getPages("SAMEwORD"));
		assertEquals(list1, Main.getPages("SAMEWORD"));
		
		Main.index(page2);
		
		assertEquals(list2, Main.getPages("sameword"));
		assertEquals(list2, Main.getPages("Sameword"));
		assertEquals(list2, Main.getPages("SAMEwORD"));
		assertEquals(list2, Main.getPages("SAMEWORD"));
		
		Main.index(page3);
		
		assertEquals(list3, Main.getPages("sameword"));
		assertEquals(list3, Main.getPages("Sameword"));
		assertEquals(list3, Main.getPages("SAMEwORD"));
		assertEquals(list3, Main.getPages("SAMEWORD"));
		
	}
	
	@Test
	void getPagesRepeatedSamePageIndex() {
		Main.index(page1);
		
		assertEquals(list1, Main.getPages("sameword"));
		assertEquals(list1, Main.getPages("SAMEWORD"));
		
		Main.index(page1);
		Main.index(page1);
		Main.index(page2);
		Main.index(page1);
		Main.index(page1);
		
		assertEquals(list2, Main.getPages("sameword"));
		assertEquals(list2, Main.getPages("SAMEWORD"));
		
		Main.index(page1);
		Main.index(page3);
		Main.index(page2);
		Main.index(page3);
		Main.index(page1);
		
		assertEquals(list3, Main.getPages("sameword"));
		assertEquals(list3, Main.getPages("SAMEWORD"));
		
	}
	
	@Test
	void getPagesNullArgs() {
		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
				() -> Main.getPages(null));
		assertEquals("Null args", ex.getMessage());
	}
	
	@Test
	void removePage() {
		
		assertFalse(Main.getMap().containsValue(listImmutable1));
		assertFalse(Main.getMap().containsValue(listImmutable2));
		assertFalse(Main.getMap().containsValue(listImmutable3));
		
		Main.getMap().put("TestWord", list1);
		assertTrue(Main.getMap().containsValue(listImmutable1));
		
		Main.getMap().put("TestWord", list2);
		assertTrue(Main.getMap().containsValue(listImmutable2));
		
		Main.getMap().put("TestWord", list3);
		assertTrue(Main.getMap().containsValue(listImmutable3));
		
		Main.removePage("http://tee.com");
		assertFalse(Main.getMap().containsValue(listImmutable3));
		assertTrue(Main.getMap().containsValue(listImmutable2));
		
		Main.removePage("http://baa.es");
		assertFalse(Main.getMap().containsValue(listImmutable2));
		assertTrue(Main.getMap().containsValue(listImmutable1));
		
		Main.removePage("http://foo.com");
		assertFalse(Main.getMap().containsValue(listImmutable1));
		assertTrue(Main.getMap().containsValue(new ArrayList<>()));
	}
	
	@Test
	void removePageNullArgs() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
				() -> Main.removePage(null));
		assertEquals("Null args", ex.getMessage());
	}
}
