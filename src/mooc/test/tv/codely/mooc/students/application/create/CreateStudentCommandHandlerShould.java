package tv.codely.mooc.students.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentMother;
import tv.codely.mooc.students.domain.StudentRegisteredDomainEventMother;
import tv.codely.mooc.students.infraestructure.StudentModuleUnitTestCase;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

final class CreateStudentCommandHandlerShould extends StudentModuleUnitTestCase {

    private CreateStudentCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateStudentCommandHandler(new StudentCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_student() {
        CreateStudentCommand command = CreateStudentCommandMother.random();

        Student student      = StudentMother.fromRequest(command);
        StudentRegisteredDomainEvent domainEvent =
            StudentRegisteredDomainEventMother.fromStudent(student);

        handler.handle(command);

        shouldHaveSaved(student);

        shouldHavePublished(domainEvent);
    }
}
