package tv.codely.backoffice.videos.application;

import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.shared.domain.bus.query.Response;

public final class BackofficeVideoResponse implements Response {
    private final String id;

    private final String text;

    private final String title;

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

    private final String url;

    public BackofficeVideoResponse(String id, String text, String title, String url) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.url = url;
    }

    // factory method, naming constructor
    public static BackofficeVideoResponse fromAggregate(BackofficeVideo video) {
        return new BackofficeVideoResponse(video.id(), video.text(), video.title(), video.url());
    }
}


