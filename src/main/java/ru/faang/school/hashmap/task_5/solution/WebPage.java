package ru.faang.school.hashmap.task_5.solution;

public class WebPage {

  private String url;

  private String title;

  private String content;

  public String getUrl() {
    return url;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public WebPage(String url, String title, String content) {
    this.url = url;
    this.title = title;
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WebPage webPage = (WebPage) o;

    return getUrl() != null ? getUrl().equals(webPage.getUrl()) : webPage.getUrl() == null;
  }

  @Override
  public int hashCode() {
    return getUrl() != null ? getUrl().hashCode() : 0;
  }

  @Override
  public String toString() {
    return "WebPage{" +
        "url='" + url + '\'' +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
