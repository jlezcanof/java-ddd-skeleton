package tv.codely.backoffice.videos.domain;

import java.util.Arrays;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.domain.criteria.Filter;
import tv.codely.shared.domain.criteria.Filters;
import tv.codely.shared.domain.criteria.Order;

public final class BackofficeVideoCriteriaMother {
    public static Criteria textAndTitleAndUrlContains(String text, String title, String url) {
        Filter textFilter  = Filter.create("text",  "contains", text);
        Filter titleFilter = Filter.create("title", "contains", title);
        Filter urlFilter   = Filter.create("url",  "contains", url);

        return new Criteria(new Filters(Arrays.asList(titleFilter, textFilter, urlFilter)),
            Order.asc(
                "name"));
    }
}
