package tv.codely.mooc.students.infrastructure;

import java.util.HashMap;
import java.util.Map;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.domain.StudentSurname;
import tv.codely.shared.domain.UuidGenerator;

import java.util.Arrays;
import java.util.List;

public final class InMemoryStudentRepository implements StudentRepository {
    private UuidGenerator generator;
    private Map<String, Student> students = new HashMap<>();

    public InMemoryStudentRepository(UuidGenerator generator) {
        this.generator = generator;
    }

    @Override
    public List<Student> searchAll() {
        return Arrays.asList(
            new Student(new StudentId(generator.generate()), new StudentName("name"),
                new StudentSurname("surname"),
                new StudentEmail("email@mail.com")),
            new Student(new StudentId(generator.generate()), new StudentName("Other name"),
                new StudentSurname("Other surname"), new StudentEmail("another@mail.com"))
        );
    }

    @Override
    public void register(Student student) {
            students.put(student.id().value(), student);
    }
}
