package tv.codely.backoffice.videos.infrastructure.persistence;

import java.util.List;
import org.springframework.context.annotation.Primary;
import tv.codely.backoffice.videos.domain.BackofficeVideo;
import tv.codely.backoffice.videos.domain.BackofficeVideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.infrastructure.elasticsearch.ElasticsearchClient;
import tv.codely.shared.infrastructure.elasticsearch.ElasticsearchRepository;

@Primary
@Service
public final class ElastichsearchBackofficeVideoRepository extends ElasticsearchRepository<BackofficeVideo> implements
    BackofficeVideoRepository {

    public ElastichsearchBackofficeVideoRepository(ElasticsearchClient client) {
        super(client);
    }

    @Override
    public void save(BackofficeVideo video) {
        persist(video.id(), video.toPrimitives());
    }

    @Override
    public List<BackofficeVideo> matching(Criteria criteria) {
        return searchByCriteria(criteria, BackofficeVideo::fromPrimitives);
    }

    @Override
    public List<BackofficeVideo> searchAll() {
        return searchAllInElastic(BackofficeVideo::fromPrimitives);
    }

    @Override
    protected String moduleName() {
        return "videos";
    }
}
