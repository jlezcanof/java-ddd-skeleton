package tv.codely.mooc.students_register.application.incrementer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentRegisteredDomainEventMother;
import tv.codely.mooc.students_register.StudentsRegisterModuleUnitTestCase;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.mooc.students_register.domain.StudentsRegisterMother;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

final class IncrementStudentsCounterOnStudentRegisteredShould extends StudentsRegisterModuleUnitTestCase {
    IncrementerStudentsOnStudentRegistered subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new IncrementerStudentsOnStudentRegistered(
            new StudentsRegisterIncrementer(repository, uuidGenerator)
        );
    }

    @Test
    void it_should_initialize_a_new_student_register() {
        StudentRegisteredDomainEvent event =
            StudentRegisteredDomainEventMother.random();

        StudentId       studentId   = StudentIdMother.create(event.aggregateId());
        StudentsRegister newStudentRegister =
            StudentsRegisterMother.withOne(studentId);

        shouldSearch();
        shouldGenerateUuid(newStudentRegister.id().value());

        subscriber.on(event);

        shouldHaveSaved(newStudentRegister);
    }

    @Test
    void it_should_increment_an_existing_student() {
        StudentRegisteredDomainEvent event = StudentRegisteredDomainEventMother.random();

        StudentId       studentId            = StudentIdMother.create(event.aggregateId());
        StudentsRegister existingRegister    = StudentsRegisterMother.random();
        StudentsRegister incrementedRegister =
            StudentsRegisterMother.incrementing(existingRegister, studentId);

        shouldSearch(existingRegister);

        subscriber.on(event);

        shouldHaveSaved(incrementedRegister);
    }

    @Test
    void it_should_not_increment_an_already_incremented_student() {
        StudentRegisteredDomainEvent event = StudentRegisteredDomainEventMother.random();

        StudentId       courseId          = StudentIdMother.create(event.aggregateId());
        StudentsRegister existingRegister = StudentsRegisterMother.withOne(courseId);

        shouldSearch(existingRegister);

        subscriber.on(event);
    }
}
