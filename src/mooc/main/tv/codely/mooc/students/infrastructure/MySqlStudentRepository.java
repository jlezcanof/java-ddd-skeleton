package tv.codely.mooc.students.infrastructure;

import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

//@Service
//@Transactional("mooc-transaction_manager")
public final class MySqlStudentRepository extends HibernateRepository<Student> implements
    StudentRepository {//@Qualifier("mooc-session_factory")
    public MySqlStudentRepository(SessionFactory sessionFactory,
                                  Class<Student> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void register(Student student) {
        persist(student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return byId(id);
    }

    @Override
    public List<Student> searchAll() {
        return all();
    }
}
