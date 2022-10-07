package tv.codely.backoffice.videos.infrastructure.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoCriteriaMother;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.criteria.Criteria;

final class InMemoryCacheBackofficeVideoRepositoryShould extends BackofficeContextInfrastructureTestCase {
    private InMemoryCacheBackofficeVideoRepository repository;
    private BackofficeVideoRepository              innerRepository;

    @BeforeEach
    protected void setUp() {
        innerRepository = mock(BackofficeVideoRepository.class);
        repository      = new InMemoryCacheBackofficeVideoRepository(innerRepository);
    }

    @Test
    void save_a_video() {
        BackofficeVideo video = BackofficeVideoMother.random();

        repository.save(video);

        shouldHaveSaved(video);
    }

    @Test
    void search_all_existing_videos() {
        BackofficeVideo       video        = BackofficeVideoMother.random();
        BackofficeVideo       anotherVideo = BackofficeVideoMother.random();
        List<BackofficeVideo> videos       = Arrays.asList(video, anotherVideo);

        shouldSearchAll(videos);

        assertThat(videos, containsInAnyOrder(repository.searchAll().toArray()));
    }

    @Test
    void search_all_existing_videos_without_hitting_the_inner_repository_the_second_time() {
        BackofficeVideo       video        = BackofficeVideoMother.random();
        BackofficeVideo       anotherVideo = BackofficeVideoMother.random();
        List<BackofficeVideo> videos       = Arrays.asList(video, anotherVideo);

        shouldSearchAll(videos);

        assertThat(videos, containsInAnyOrder(repository.searchAll().toArray()));
        assertThat(videos, containsInAnyOrder(repository.searchAll().toArray()));
    }

    @Test
    void search_videos_using_a_criteria() {
        BackofficeVideo matchingVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "java", "DDD en Java",
            "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo anotherMatchingVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "javascript",
            "DDD en javascript", "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo dddVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "typescript",
            "DDD en typescript", "https://mvnrepository.com/");


        List<BackofficeVideo> matchingVideos = Arrays.asList(matchingVideo, anotherMatchingVideo,
            dddVideo);

        Criteria criteria =
            BackofficeVideoCriteriaMother.textAndTitleAndUrlContains("video", "DDD", "mysql");

        shouldSearchMatching(criteria, matchingVideos);

        assertThat(matchingVideos, containsInAnyOrder(repository.matching(criteria).toArray()));
    }



    @Test
    void search_courses_using_a_criteria_without_hitting_the_inner_repository_the_second_time() {
        BackofficeVideo matchingVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "java", "DDD en Java",
            "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo anotherMatchingVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "javascript",
            "DDD en javascript", "https://www.mysqltutorial.org/mysql-show-databases");

        BackofficeVideo dddVideo = BackofficeVideoMother.create("video sobre ddd en "
                + "typescript",
            "DDD en typescript", "https://mvnrepository.com/");


        List<BackofficeVideo> matchingVideos = Arrays.asList(matchingVideo, anotherMatchingVideo,
            dddVideo);

        Criteria criteria =
            BackofficeVideoCriteriaMother.textAndTitleAndUrlContains("video", "DDD", "mysql");

        shouldSearchMatching(criteria, matchingVideos);

        assertThat(matchingVideos, containsInAnyOrder(repository.matching(criteria).toArray()));
        assertThat(matchingVideos, containsInAnyOrder(repository.matching(criteria).toArray()));
    }

    private void shouldSearchAll(List<BackofficeVideo> video) {
        Mockito.when(innerRepository.searchAll()).thenReturn(video);
    }

    private void shouldSearchMatching(Criteria criteria, List<BackofficeVideo> videos) {
        Mockito.when(innerRepository.matching(criteria)).thenReturn(videos);
    }

    private void shouldHaveSaved(BackofficeVideo video) {
        verify(innerRepository, atLeastOnce()).save(video);
    }
}
