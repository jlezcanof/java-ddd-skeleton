package tv.codely.backoffice.videos.application.create;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

@Service
@DomainEventSubscriber({VideoCreatedDomainEvent.class})
public final class CreateBackofficeVideoOnVideoCreated {
    private final BackofficeVideoCreator creator;

    public CreateBackofficeVideoOnVideoCreated(BackofficeVideoCreator creator) {
        this.creator = creator;
    }

    public void on(VideoCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.text(), event.title(), event.url());
    }
}
