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
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;

final class ElasticsearchBackofficeVideoRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    private ElastichsearchBackofficeVideoRepository repository;

    @BeforeEach
    protected void setUp() throws IOException {
        clearElasticsearch();
    }

    @Test
    void save_a_course() {
        repository.save(BackofficeVideoMother.random());
    }

    @Test
    void search_all_existing_courses() throws Exception {
        BackofficeVideo video        = BackofficeVideoMother.random();
        BackofficeVideo anotherVideo = BackofficeVideoMother.random();

        List<BackofficeVideo> expected = Arrays.asList(video, anotherVideo);

        repository.save(video);
        repository.save(anotherVideo);

        eventually(() -> assertEquals(expected, repository.searchAll()));
    }

//    @Test//TODO preparar
//    void search_courses_using_a_criteria() throws Exception {
//        BackofficeVideo matchingCourse        = BackofficeVideoMother.create("DDD en Java", "3 days");
//        BackofficeVideo anotherMatchingCourse = BackofficeVideoMother.create("DDD en TypeScript", "2.5 days");
//        BackofficeVideo intellijCourse        = BackofficeVideoMother.create("Exprimiendo Intellij", "48 hours");
//        BackofficeVideo cobolCourse           = BackofficeVideoMother.create("DDD en Cobol", "5 years");
//
//        Criteria               criteria =
//            BackofficeVideoCriteriaMother.titleAndTextAndUrlContains("Patron "
//                + "criteria/specification", "se explica como usar el patron creacional criteria",
//                "https://www.youtube.com/watch?v=8BflD134BKM");
//        List<BackofficeVideo> expected = Arrays.asList(matchingCourse, anotherMatchingCourse);
//
//        repository.save(matchingCourse);
//        repository.save(anotherMatchingCourse);
//        repository.save(intellijCourse);
//        repository.save(cobolCourse);
//
//        eventually(() -> assertEquals(expected, repository.matching(criteria)));
//    }
}
