package tv.codely.backoffice.videos.application.search_all;

import java.util.stream.Collectors;
import tv.codely.backoffice.courses.application.BackofficeCourseResponse;
import tv.codely.backoffice.courses.application.BackofficeCoursesResponse;
import tv.codely.backoffice.courses.domain.BackofficeCourseRepository;
import tv.codely.shared.domain.Service;

@Service
public final class AllBackofficeVideosSearcher {
    private final BackofficeCourseRepository repository;

    public AllBackofficeVideosSearcher(BackofficeCourseRepository repository) {
        this.repository = repository;
    }

    public BackofficeCoursesResponse search() {
        return new BackofficeCoursesResponse(
            repository.searchAll().stream().map(BackofficeCourseResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
