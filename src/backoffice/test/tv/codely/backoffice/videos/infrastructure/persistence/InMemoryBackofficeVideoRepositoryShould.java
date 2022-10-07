package tv.codely.backoffice.videos.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.backoffice.BackofficeContextInfrastructureTestCase;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoMother;

final class InMemoryBackofficeVideoRepositoryShould extends
    BackofficeContextInfrastructureTestCase {
    
    private InMemoryBackofficeVideoRepository inMemoryBackofficeVideoRepository =
        new InMemoryBackofficeVideoRepository();
    @Test
    void save_a_video() {
        BackofficeVideo video = BackofficeVideoMother.random();

        inMemoryBackofficeVideoRepository.save(video);
    }
}
