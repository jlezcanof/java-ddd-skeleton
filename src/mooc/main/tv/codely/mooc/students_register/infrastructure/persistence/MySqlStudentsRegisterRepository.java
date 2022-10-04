package tv.codely.mooc.students_register.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.mooc.students_register.domain.StudentsRegisterRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlStudentsRegisterRepository extends HibernateRepository<StudentsRegister>
    implements StudentsRegisterRepository {


    public MySqlStudentsRegisterRepository(@Qualifier("mooc-session_factory")
                                         SessionFactory sessionFactory) {
        super(sessionFactory, StudentsRegister.class);
    }
    @Override
    public void save(StudentsRegister register) {
        persist(register);
    }

    @Override
    public Optional<StudentsRegister> search() {
        List<StudentsRegister> studentsRegisters = all();

        return 0 == studentsRegisters.size() ? Optional.empty() : Optional.ofNullable(studentsRegisters.get(0));
    }
}
