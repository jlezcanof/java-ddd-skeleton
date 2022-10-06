package tv.codely.shared.domain.video;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import tv.codely.shared.domain.bus.event.DomainEvent;

public final class VideoCreatedDomainEvent extends DomainEvent {

    private final String url;

    private final String text;

    private final String title;



    public VideoCreatedDomainEvent() {
        super(null);

        this.url   = null;
        this.text  = null;
        this.title = null;
    }

    public VideoCreatedDomainEvent(String aggregateId, String url, String text, String title) {
        super(aggregateId);

        this.url   = url;
        this.text  = text;
        this.title = title;
    }

    public VideoCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String url,
        String text,
        String title
                                  ) {
        super(aggregateId, eventId, occurredOn);

        this.url   = url;
        this.text  = text;
        this.title = title;
    }

    @Override
    public String eventName() {
        return "course.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("url", url);
            put("text", text);
            put("title", title);
        }};
    }

    @Override
    public VideoCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
                                                 ) {
        return new VideoCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("url"),
            (String) body.get("text"),
            (String) body.get("title")
        );
    }

    public String url() {
        return url;
    }

    public String text() {
        return text;
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoCreatedDomainEvent that = (VideoCreatedDomainEvent) o;
        return url.equals(that.url) &&
            text.equals(that.text) &&
               title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, text, title);
    }
}
