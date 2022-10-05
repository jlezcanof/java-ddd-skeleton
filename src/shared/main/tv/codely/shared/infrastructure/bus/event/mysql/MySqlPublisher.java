package tv.codely.shared.infrastructure.bus.event.mysql;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import tv.codely.shared.domain.Utils;
import tv.codely.shared.domain.bus.event.DomainEvent;

public final class MySqlPublisher {

    private final SessionFactory sessionFactory;

    public MySqlPublisher(SessionFactory
                              sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void publish(DomainEvent domainEvent) throws SQLException {
        String                        id          = domainEvent.eventId();
        String                        aggregateId = domainEvent.aggregateId();
        String                        name        = domainEvent.eventName();
        HashMap<String, Serializable> body        = domainEvent.toPrimitives();
        String                        occurredOn  = domainEvent.occurredOn();

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
            "INSERT INTO domain_events (id,  aggregate_id, name,  body,  occurred_on) " +
                "VALUES (:id, :aggregateId, :name, :body, :occurredOn);"
                                                                                );

        query.setParameter("id", id)
            .setParameter("aggregateId", aggregateId)
            .setParameter("name", name)
            .setParameter("body", Utils.jsonEncode(body))
            .setParameter("occurredOn", occurredOn);

        query.executeUpdate();
    }
}
