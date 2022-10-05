package tv.codely.shared.infrastructure.bus.event.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Qualifier;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

import java.util.Collections;
import java.util.List;

public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final EventBus          failoverPublisher;
    private final String            exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher,
                            @Qualifier("MySqlEventBus") EventBus failoverPublisher) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
