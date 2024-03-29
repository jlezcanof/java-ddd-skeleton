package tv.codely.mooc.courses.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

import java.util.Objects;

public final class Course extends AggregateRoot {
    private final CourseId       id;
    private final CourseName     name;
    private final CourseDuration duration;

    public Course(CourseId id, CourseName name, CourseDuration duration) {
        this.id       = id;
        this.name     = name;
        this.duration = duration;
    }

    private Course() {
        id       = null;
        name     = null;
        duration = null;
    }

    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = new Course(id, name, duration);

        course.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value()));

        return course;
    }

    public CourseId id() {
        return id;
    }

    public CourseName name() {
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
        Course course = (Course) o;
        return id.equals(course.id) &&
               name.equals(course.name) &&
               duration.equals(course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }

    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id.value());
            put("name", name.value());
            put("duration", duration.value());
        }};
    }

    public static Course fromPrimitives(Map<String, Object> plainData) {
        return new Course(new CourseId((String) plainData.get("id")),
            new CourseName((String) plainData.get("name")),
            new CourseDuration((String) plainData.get("duration"))
        );
    }
}
