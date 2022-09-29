package tv.codely.mooc.students.application.create;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.domain.StudentSurname;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class StudentCreator {
    private final StudentRepository repository;
    private final EventBus         eventBus;

    public StudentCreator(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        //Student student = Student.c
        //Course course = Course.create(id, name, duration);

        //repository.save(course);
        //eventBus.publish(course.pullDomainEvents());
    }
}
