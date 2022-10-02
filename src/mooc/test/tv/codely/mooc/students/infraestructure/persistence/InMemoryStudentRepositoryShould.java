package tv.codely.mooc.students.infraestructure.persistence;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;
import tv.codely.mooc.students.infraestructure.StudentCreateModuleInfrastructureTestCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public final class InMemoryStudentRepositoryShould extends
    StudentCreateModuleInfrastructureTestCase {

    @Test
    void save_a_student() {
        Student student = StudentMother.random();

        inMemoryStudentRepository.register(student);
    }

    @Test
    void return_an_existing_student() {
        Student student = StudentMother.random();

        inMemoryStudentRepository.register(student);

        assertEquals(Optional.of(student), inMemoryStudentRepository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        assertFalse(inMemoryStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}
