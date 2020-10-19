package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> searchAll();
    void save(Student student);
    Optional<Student> search(StudentId id);
    List<Student> matching(Criteria criteria);
}
