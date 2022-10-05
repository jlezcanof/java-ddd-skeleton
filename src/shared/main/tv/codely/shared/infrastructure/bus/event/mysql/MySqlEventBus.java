package tv.codely.shared.infrastructure.bus.event.mysql;

import java.sql.SQLException;
import java.util.Collections;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

import java.util.List;
import tv.codely.shared.infrastructure.bus.inmemory.InMemoryEventBus;

public final class MySqlEventBus implements EventBus {
    private final MySqlPublisher publisher;

    private final InMemoryEventBus failoverPublisher;

    public MySqlEventBus(MySqlPublisher publisher,
                         InMemoryEventBus failoverPublisher) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent);
        } catch (SQLException e) {
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
