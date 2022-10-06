package tv.codely.mooc.steps.domain.video;

import java.util.Objects;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

public final class Video extends AggregateRoot {

    private final StepId id;
    private final VideoStepText text;
    private VideoUrl url;
    private StepTitle title;

    public Video(StepId id, VideoStepText text, VideoUrl url, StepTitle title) {
        this.id    = id;
        this.text  = text;
        this.url   = url;
        this.title = title;
    }


    private Video() {
        id       = null;
        text     = null;
        url      = null;
        title    = null;
    }

    public static Video create(StepId id, VideoStepText text, VideoUrl url, StepTitle title) {
        Video video = new Video(id, text, url, title);

        video.record(new VideoCreatedDomainEvent(id.value(), url.value(), text.value(), title.value()));

        return video;
    }

    public StepId id() {
        return id;
    }

    public VideoUrl url() {
        return url;
    }

    public VideoStepText text() {
        return text;
    }

    public StepTitle title() {
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
        Video video = (Video) o;
        return id.equals(video.id) &&
               url.equals(video.url) &&
               title.equals(video.title) &&
               text.equals(video.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, title, text);
    }
}
