package tv.codely.backoffice.videos.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class MySqlBackofficeVideoRepository extends HibernateRepository<BackofficeVideo>
    implements BackofficeVideoRepository {

    public MySqlBackofficeVideoRepository(@Qualifier("backoffice-session_factory")  SessionFactory sessionFactory) {
        super(sessionFactory, BackofficeVideo.class);
    }

    @Override
    public void save(BackofficeVideo video) {
        persist(video);
    }
}
