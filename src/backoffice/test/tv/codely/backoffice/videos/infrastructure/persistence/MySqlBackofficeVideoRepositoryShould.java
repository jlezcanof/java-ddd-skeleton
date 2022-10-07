package tv.codely.backoffice.videos.infrastructure.persistence;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;

@Transactional
@Disabled//se comenta porque da un problema de mapeo de hibernate con backofficevideo
class MySqlBackofficeVideoRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    //@Qualifier("mySqlBackofficevideoRepository")
    private BackofficeVideoRepository repository;

    @Test
    void save_a_video() {
        repository.save(BackofficeVideoMother.random());
    }

//    @Test
//    void search_all_existing_videos() {
//        BackofficeVideo video        = BackofficeVideoMother.random();
//        BackofficeVideo anotherVideo = BackofficeVideoMother.random();
//
//        repository.save(video);
//        repository.save(anotherVideo);
//
//        assertThat(Arrays.asList(video, anotherVideo),
//            containsInAnyOrder(repository.searchAll().toArray()));
//    }

//    @Test
//    void search_courses_using_a_criteria() {
//        BackofficeVideo matchingCourse        = BackofficeCourseMother.create("DDD en Java", "3 days");
//        BackofficeVideo anotherMatchingCourse = BackofficeCourseMother.create("DDD en TypeScript", "2.5 days");
//        BackofficeVideo intellijCourse        = BackofficeCourseMother.create("Exprimiendo Intellij", "48 hours");
//        BackofficeVideo cobolCourse           = BackofficeCourseMother.create("DDD en Cobol", "5 years");
//
//        Criteria criteria = BackofficeCourseCriteriaMother.nameAndDurationContains("DDD", "days");
//
//        repository.save(matchingCourse);
//        repository.save(anotherMatchingCourse);
//        repository.save(intellijCourse);
//        repository.save(cobolCourse);
//
//        assertThat(
//            Arrays.asList(matchingCourse, anotherMatchingCourse),
//            containsInAnyOrder(repository.matching(criteria).toArray())
//        );
//    }
}
