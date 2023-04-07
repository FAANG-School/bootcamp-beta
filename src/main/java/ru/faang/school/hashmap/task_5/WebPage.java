package ru.faang.school.hashmap.task_5;

import java.util.Objects;

public class WebPage {
	
	private final String url;
	private final String title;
	private final String content;
	
	public WebPage(String url, String title, String content) {
		if (url == null || title == null || content == null) {
			throw new IllegalArgumentException("Null agrs of WebPage");
		}
		this.url = url;
		this.title = title;
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, title, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebPage other = (WebPage) obj;
		return Objects.equals(content, other.content) && Objects.equals(title, other.title)
				&& Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return url;
	}
}
