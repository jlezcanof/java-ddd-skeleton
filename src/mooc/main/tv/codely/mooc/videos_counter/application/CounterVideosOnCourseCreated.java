package tv.codely.mooc.videos_counter.application;


import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

//@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class CounterVideosOnCourseCreated {

    private final VideosCounterCourseCreator videosCounterCourseCreator;

    public CounterVideosOnCourseCreated(VideosCounterCourseCreator videosCounterCourseCreator) {
        this.videosCounterCourseCreator = videosCounterCourseCreator;

    }
}
