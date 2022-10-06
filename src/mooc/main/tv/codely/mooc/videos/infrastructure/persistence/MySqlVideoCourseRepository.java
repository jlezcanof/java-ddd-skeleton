package tv.codely.mooc.videos.infrastructure.persistence;

import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlVideoCourseRepository extends HibernateRepository<Video> implements
    VideoRepository {
    public MySqlVideoCourseRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Video.class);
    }

    @Override
    public Optional<Video> search(VideoId id) {
        return byId(id);
    }

}
