package tv.codely.mooc.videos.domain;

import java.util.Objects;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

public final class Video extends AggregateRoot {
    private final VideoId id;
    private final VideoName name;
    private final CourseDuration duration;

    public Video(VideoId id, VideoName name, CourseDuration duration) {
        this.id       = id;
        this.name     = name;
        this.duration = duration;
    }

    private Video() {
        id       = null;
        name     = null;
        duration = null;
    }

    public static Video create(VideoId id, VideoName name, CourseDuration duration) {
        Video course = new Video(id, name, duration);

        course.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value()));

        return course;
    }

    public VideoId id() {
        return id;
    }

    public VideoName name() {
        return name;
    }

    public CourseDuration duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Video course = (Video) o;
        return id.equals(course.id) &&
               name.equals(course.name) &&
               duration.equals(course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
