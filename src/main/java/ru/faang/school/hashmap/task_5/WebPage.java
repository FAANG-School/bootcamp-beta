import java.util.Objects;

public class WebPage {
    private final String URL;
    private final String title;
    private final String content;

    public WebPage(String URL, String title, String content) {
        this.URL = URL;
        this.title = title;
        this.content = content;
    }

    public String getURL() {
        return URL;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(URL, webPage.URL) && Objects.equals(title, webPage.title) && Objects.equals(content, webPage.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(URL, title, content);
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "URL='" + URL + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
