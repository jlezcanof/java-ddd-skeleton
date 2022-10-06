package tv.codely.backoffice.videos.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;
import tv.codely.backoffice.videos.infrastructure.BackofficeVideoCreateModuleInfrastructureTestCase;

final class InMemoryBackofficeVideoRepositoryShould extends
    BackofficeVideoCreateModuleInfrastructureTestCase {

    @Test
    void save_a_course() {
        BackofficeVideo video = BackofficeVideoMother.random();

        inMemoryBackofficeVideoRepository.save(video);
    }
}
