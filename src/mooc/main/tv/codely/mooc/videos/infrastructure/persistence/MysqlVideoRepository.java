package tv.codely.mooc.videos.infrastructure.persistence;

import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("mooc-transaction_manager")
public class MysqlVideoRepository extends HibernateRepository<VideoStep>
    implements VideoRepository {
    public MysqlVideoRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, VideoStep.class);
    }

    @Override
    public Optional<VideoStep> search(StepId videoId) {
        return byId(videoId);
    }

    @Override
    public void save(VideoStep video) {
        persist(video);
    }
}
