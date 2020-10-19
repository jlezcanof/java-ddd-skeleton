package tv.codely.mooc.students.infrastructure.persistence;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.UuidGenerator;
import tv.codely.shared.domain.criteria.Criteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private final UuidGenerator generator;
    private final HashMap<StudentId, Student> students = new HashMap<>();

    public InMemoryStudentRepository(UuidGenerator generator) {
        this.generator = generator;
    }

    @Override
    public List<Student> searchAll() {
        return Arrays.asList(
            new Student(new StudentId(generator.generate()), new StudentName("name"),new StudentSurname("surname")
                , new StudentEmail("email@mail.com")),
            new Student(new StudentId(generator.generate()), new StudentName("name2"),new StudentSurname("surname2")
                , new StudentEmail("email2@mail.com")));
    }

    @Override
    public void save(Student student) {
        students.put(student.id(), student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(students.get(id.value()));
    }

    @Override
    public List<Student> matching(Criteria criteria) {
        return null;
    }
}
