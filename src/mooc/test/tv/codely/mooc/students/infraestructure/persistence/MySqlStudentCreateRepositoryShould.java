package tv.codely.mooc.students.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import javax.transaction.Transactional;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentMother;
import tv.codely.mooc.students.infraestructure.StudentCreateModuleInfrastructureTestCase;

@Transactional
class MySqlStudentCreateRepositoryShould extends StudentCreateModuleInfrastructureTestCase {
    @Test
    void return_an_create_student() {
        Student creator = StudentMother.random();

        mySqlStudentRepository.register(creator);

        assertEquals(Optional.of(creator), mySqlStudentRepository.search(creator.id()));
    }
}
