package tv.codely.backoffice.videos.application.search_all;

import tv.codely.backoffice.courses.application.BackofficeCoursesResponse;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllBackofficeVideosQueryHandler implements QueryHandler<SearchAllBackofficeVideosQuery, BackofficeCoursesResponse> {
    private final AllBackofficeVideosSearcher
        searcher;

    public SearchAllBackofficeVideosQueryHandler(AllBackofficeVideosSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BackofficeCoursesResponse handle(SearchAllBackofficeVideosQuery query) {
        return searcher.search();
    }
}
