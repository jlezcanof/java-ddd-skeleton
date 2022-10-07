package tv.codely.backoffice.videos.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoCriteriaMother;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;
import tv.codely.shared.domain.criteria.Criteria;

final class ElasticsearchBackofficeVideoRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    private ElastichsearchBackofficeVideoRepository repository;

    @BeforeEach
    protected void setUp() throws IOException {
        clearElasticsearch();
    }

    @Test
    void save_a_video() {
        repository.save(BackofficeVideoMother.random());
    }

    @Test
    void search_all_existing_videos() throws Exception {
        BackofficeVideo video        = BackofficeVideoMother.random();
        BackofficeVideo anotherVideo = BackofficeVideoMother.random();

        List<BackofficeVideo> expected = Arrays.asList(video, anotherVideo);

        repository.save(video);
        repository.save(anotherVideo);

        eventually(() -> assertEquals(expected, repository.searchAll()));
    }

    @Test
    void search_videos_using_a_criteria() throws Exception {
        BackofficeVideo matchingVideo        = BackofficeVideoMother.create("video sobre ddd en "
                + "java", "DDD en Java",
            "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo anotherMatchingVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "javascript",
            "DDD en javascript", "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo dddEnTypeScript = BackofficeVideoMother.create("video sobre ddd en "
                + "typescript",
            "DDD en typescript", "https://mvnrepository.com/");


        Criteria criteria =
            BackofficeVideoCriteriaMother.textAndTitleAndUrlContains("video", "DDD", "mysql");

        List<BackofficeVideo> expected = Arrays.asList(matchingVideo, anotherMatchingVideo,
            dddEnTypeScript);

        repository.save(matchingVideo);
        repository.save(anotherMatchingVideo);
        repository.save(dddEnTypeScript);

        eventually(() -> assertEquals(expected, repository.matching(criteria)));
    }
}
