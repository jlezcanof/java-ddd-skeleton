package tv.codely.backoffice.videos.infrastructure.persistence;

import java.util.HashMap;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;

public final class InMemoryBackofficeVideoRepository implements BackofficeVideoRepository {

    private HashMap<String, BackofficeVideo> videos = new HashMap<>();

    @Override
    public void save(BackofficeVideo video) {
            videos.put(video.id(), video);
    }
}
