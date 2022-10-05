package tv.codely.mooc.students_register.application;

import tv.codely.mooc.students.domain.StudentId;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

@Service
@DomainEventSubscriber({StudentRegisteredDomainEvent.class})
public final class IncrementerStudentsOnStudentRegistered {

    private final StudentsRegisterIncrementer incrementer;

    public IncrementerStudentsOnStudentRegistered(StudentsRegisterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    public void on(StudentRegisteredDomainEvent event) {
        StudentId studentId = new StudentId(event.aggregateId());

        incrementer.increment(studentId);
    }
}
