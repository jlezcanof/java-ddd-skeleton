package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus         eventBus;

    public CourseCreator(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = Course.create(id, name, duration);

        repository.save(course);
        eventBus.publish(course.pullDomainEvents());
    }
}
