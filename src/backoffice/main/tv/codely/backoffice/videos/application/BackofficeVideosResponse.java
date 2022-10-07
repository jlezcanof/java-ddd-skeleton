package tv.codely.backoffice.videos.application;

import java.util.List;
import tv.codely.shared.domain.bus.query.Response;

public final class BackofficeVideosResponse implements Response {
    private final List<BackofficeVideoResponse> videos;

    public BackofficeVideosResponse(List<BackofficeVideoResponse> videos) {
        this.videos = videos;
    }

    public List<BackofficeVideoResponse> videos() {
        return videos;
    }
}
