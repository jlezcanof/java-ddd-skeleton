package tv.codely.backoffice.videos.infrastructure.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.codely.backoffice.courses.domain.BackofficeCourse;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.criteria.Criteria;

public final class InMemoryBackofficeVideoRepository implements BackofficeVideoRepository {

    //private HashMap<String, BackofficeVideo> videos = new HashMap<>();
    private List<BackofficeVideo> videos = new ArrayList<>();

    @Override
    public void save(BackofficeVideo video) {
        videos.add(video);
    }

    @Override
    public List<BackofficeVideo> matching(Criteria criteria) {
        return videos;//todo
    }

    @Override
    public List<BackofficeVideo> searchAll() {
        return videos;

    }

}
