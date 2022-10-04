package tv.codely.mooc.students_register.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students_register.StudentsRegisterModuleInfrastructureTestCase;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.mooc.students_register.domain.StudentsRegisterMother;

@Transactional
class MySqlStudentsRegisterRepositoryShould extends StudentsRegisterModuleInfrastructureTestCase {

    @Test
    void return_an_existing_student_register() {
        StudentsRegister register = StudentsRegisterMother.random();

        repository.save(register);

        assertEquals(Optional.of(register), repository.search());
    }
}
