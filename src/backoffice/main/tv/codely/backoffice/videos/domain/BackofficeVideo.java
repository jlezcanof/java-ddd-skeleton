package tv.codely.backoffice.videos.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class BackofficeVideo {
    private final String id;

    private final String text;

    private final String title;

    private final String url;

    public BackofficeVideo() {
        id       = null;
        text     = null;
        title    = null;
        url      = null;
    }

    public BackofficeVideo(String id, String text, String title, String url) {
        this.id       = id;
        this.text     = text;
        this.title    = title;
        this.url      = url;

    }

    public static BackofficeVideo fromPrimitives(Map<String, Object> plainData) {
        return new BackofficeVideo(
            (String) plainData.get("id"),
            (String) plainData.get("text"),
            (String) plainData.get("title"),
            (String) plainData.get("url")
        );
    }

    public String id() {
        return id;
    }

    public String text() {
        return text;
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
            put("name", text);
            put("duration", title);
            put("url", url);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackofficeVideo that = (BackofficeVideo) o;
        return id.equals(that.id) &&
               title.equals(that.title) &&
               text.equals(that.text) &&
               url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, url);
    }
}
