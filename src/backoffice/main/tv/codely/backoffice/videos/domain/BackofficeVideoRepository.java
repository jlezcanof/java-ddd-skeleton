package tv.codely.backoffice.videos.domain;

import java.util.List;
import tv.codely.backoffice.courses.domain.BackofficeCourse;
import tv.codely.shared.domain.criteria.Criteria;

public interface BackofficeVideoRepository {
    void save(BackofficeVideo video);

    List<BackofficeVideo> matching(Criteria criteria);

    List<BackofficeVideo> searchAll();
}
