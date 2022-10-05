package tv.codely.shared.infrastructure.bus.inmemory;

import java.util.ArrayList;
import java.util.List;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class InMemoryEventBus implements EventBus {

    private List<DomainEvent> events;

    public InMemoryEventBus(){
        events = new ArrayList<>();
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        events.add(domainEvent);
    }
}
