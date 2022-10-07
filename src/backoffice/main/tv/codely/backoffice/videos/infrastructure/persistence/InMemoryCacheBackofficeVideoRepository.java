package tv.codely.backoffice.videos.infrastructure.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.criteria.Criteria;

public final class InMemoryCacheBackofficeVideoRepository implements BackofficeVideoRepository {
    private final BackofficeVideoRepository              repository;

    private       List<BackofficeVideo>                  videos         = new ArrayList<>();

    private       HashMap<String, List<BackofficeVideo>> matchingVideos = new HashMap<>();

    public InMemoryCacheBackofficeVideoRepository(BackofficeVideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(BackofficeVideo video) {
        repository.save(video);
    }

    @Override
    public List<BackofficeVideo> searchAll() {
        return videos.isEmpty() ? searchAndFillCache() : videos;
    }

    @Override
    public List<BackofficeVideo> matching(Criteria criteria) {
        return matchingVideos.containsKey(criteria.serialize())
            ? matchingVideos.get(criteria.serialize())
            : searchMatchingAndFillCache(criteria);
    }

    private List<BackofficeVideo> searchMatchingAndFillCache(Criteria criteria) {
        List<BackofficeVideo> videos = repository.matching(criteria);

        this.matchingVideos.put(criteria.serialize(), videos);

        return videos;
    }

    private List<BackofficeVideo> searchAndFillCache() {
        List<BackofficeVideo> videos = repository.searchAll();

        this.videos = videos;

        return videos;
    }
}
