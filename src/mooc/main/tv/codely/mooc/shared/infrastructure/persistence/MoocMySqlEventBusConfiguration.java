package tv.codely.mooc.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tv.codely.shared.infrastructure.bus.event.DomainEventsInformation;
import tv.codely.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import tv.codely.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import tv.codely.shared.infrastructure.bus.event.mysql.MySqlPublisher;
import tv.codely.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;
import tv.codely.shared.infrastructure.bus.inmemory.InMemoryEventBus;

@Configuration
public class MoocMySqlEventBusConfiguration {
    private final SessionFactory            sessionFactory;
    private final DomainEventsInformation   domainEventsInformation;
    private final SpringApplicationEventBus bus;
    private final InMemoryEventBus memoryEventBus;

    public MoocMySqlEventBusConfiguration(
        @Qualifier("mooc-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus,
        InMemoryEventBus memoryEventBus) {
        this.sessionFactory          = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus                     = bus;
        this.memoryEventBus          = memoryEventBus;
    }

    @Bean
    public MySqlEventBus moocMysqlEventBus() {
        return new MySqlEventBus(new MySqlPublisher(sessionFactory), memoryEventBus);
    }


    @Bean
    public MySqlDomainEventsConsumer moocMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}
