package tv.codely.backoffice.videos.application.create;

import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;

@Service
public final class BackofficeVideoCreator {
    private final BackofficeVideoRepository repository;

    public BackofficeVideoCreator(BackofficeVideoRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String text, String title, String url) {
        this.repository.save(new BackofficeVideo(id, text, title, url));
    }
}
